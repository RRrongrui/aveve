package spfworld.spfworld.activity.Tribune;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.x;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ab.selector.Bimp;
import ab.selector.FileUtils;
import ab.selector.PhotoActivity;
import ab.selector.TestPicActivity;
import ab.util.AbToastUtil;
import spfworld.spfworld.R;
import spfworld.spfworld.base.BaseActivity;
import spfworld.spfworld.entity.Tribune.TribuneUp;
import spfworld.spfworld.utils.MyPopupWindow;
import spfworld.spfworld.utils.SharedHelper;
import spfworld.spfworld.utils.ToastUtils;
import spfworld.spfworld.utils.XutilsClass;
import spfworld.spfworld.utils.dialog.MyAlertDialog;
import spfworld.spfworld.widget.percent.view.NoScrollGridView;

/**
 * 论坛
 * 我的发布页
 * Created by Administrator on 2016/9/9.
 */
public class PostTribuneDateActivity extends BaseActivity implements TextWatcher {
    private static final int MAX_INPUT_LENGTH = 140;// 最大输入长度
    private static final int TAKE_PICTURE = 0x000000;
    private Button bu_topic_post_finsh;
    private TextView tv_clay,mHintView;
    private EditText etTitle ,etEssay;
    private RelativeLayout layout;
    private SharedHelper sharedHelper;
    private NoScrollGridView mGridView;
    private GridAdapter5 mAdapter;
    private String mImageFileName;
    public static String mImagePath;
    public List<String> list;


    @Override
    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.tribune_post_date_activity);
        x.view().inject(this);
        sharedHelper=new SharedHelper(this);
        initView();
        initbt();
    }

    private void initbt() {
        bu_topic_post_finsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MyAlertDialog myAlertDialog=new MyAlertDialog(PostTribuneDateActivity.this);
                myAlertDialog.setTitle("提示");
                myAlertDialog.setMessage("确认要舍弃内容并退出当前页面吗?");
                myAlertDialog.SetCancelButton("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myAlertDialog.Dismiss();
                        FileUtils.deleteDir();
                        Bimp.mBmps.clear();
                        Bimp.mDrr.clear();
                        Bimp.mMax = 0;
                        finish();
                    }
                });
                myAlertDialog.SetDetermineButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myAlertDialog.Dismiss();
                    }
                });
                myAlertDialog.Show();

            }
        });
        tv_clay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetReleaseTribune();
            }
        });
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSystemKeyBoard(PostTribuneDateActivity.this,layout);
            }
        });
    }
    private void initView() {
        bu_topic_post_finsh = (Button) findViewById(R.id.bu_topic_post_finsh);
        tv_clay = (TextView) findViewById(R.id.tv_clay);
        mHintView= (TextView) findViewById(R.id.tv_hint);
        etTitle = (EditText) findViewById(R.id.et_post_title);
        etEssay = (EditText) findViewById(R.id.et_post_essay);
        layout = (RelativeLayout) findViewById(R.id.layout);
        mGridView = (NoScrollGridView) findViewById(R.id.gv_gridview);
        mGridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        mAdapter = new GridAdapter5(this);
        mAdapter.update();
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                if (arg2 == Bimp.mBmps.size()) {
                    showPopupWindow();
                } else {
                    Intent intent = new Intent(PostTribuneDateActivity.this, PhotoActivity.class);
                    intent.putExtra("ID", arg2);
                    startActivity(intent);
                }
            }
        });
    }
    private void showPopupWindow() {
        MyPopupWindow popupWindow = new MyPopupWindow(this);
        String[] str = {"拍照","从相册中选择"};
        popupWindow.showPopupWindowForFoot(str, new MyPopupWindow.Callback() {
            @Override
            public void callback(String text, int position) {
                switch (position) {
                    case 0:
                        photo();
                        break;
                    case 1:
                        Intent intent = new Intent(PostTribuneDateActivity.this, TestPicActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
    @SuppressLint("HandlerLeak")
    public class GridAdapter5 extends BaseAdapter {
        private LayoutInflater inflater; // 视图容器
        private int selectedPosition = -1;// 选中的位置
        private boolean shape;

        public boolean isShape() {
            return shape;
        }

        public void setShape(boolean shape) {
            this.shape = shape;
        }

        public GridAdapter5(Context context) {
            inflater = LayoutInflater.from(context);
        }

        public void update() {
            loading();
        }

        public int getCount() {
            return (Bimp.mBmps.size() + 1);
        }

        public Object getItem(int arg0) {
            return null;
        }

        public long getItemId(int arg0) {
            return 0;
        }

        public void setSelectedPosition(int position) {
            selectedPosition = position;
        }

        public int getSelectedPosition() {
            return selectedPosition;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.item_published_grida, parent, false);
                holder = new ViewHolder();
                holder.image = (ImageView) convertView.findViewById(R.id.item_grida_image);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == Bimp.mBmps.size()) {
                holder.image.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.add_pic));
                if (position == 9) {
                    holder.image.setVisibility(View.GONE);
                }
            }else {
                holder.image.setImageBitmap(Bimp.mBmps.get(position));
            }
            return convertView;
        }

        public class ViewHolder {
            public ImageView image;
        }
        Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        mAdapter.notifyDataSetChanged();
                        break;
                }
                super.handleMessage(msg);
            }
        };
        public void loading() {
            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        if (Bimp.mMax == Bimp.mDrr.size()) {
                            Message message = new Message();
                            message.what = 1;
                            handler.sendMessage(message);
                            break;
                        } else {
                            try {
                                if(Bimp.mDrr.size() <= 0)
                                    return;
                                String path = Bimp.mDrr.get(Bimp.mMax);
                                Bitmap bm = Bimp.revitionImageSize(path);
                                Bimp.mBmps.add(bm);
                                uploadFile(bm);
                                String newStr = path.substring(path.lastIndexOf("/") + 1,path.lastIndexOf("."));
                                FileUtils.saveBitmap(bm, "" + newStr);
                                Bimp.mMax += 1;
                                Message message = new Message();
                                message.what = 1;
                                handler.sendMessage(message);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }).start();
        }
    }

    public String getString(String s) {
        String path = null;
        if (s == null)
            return "";
        for (int i = s.length() - 1; i > 0; i++) {
            s.charAt(i);
        }
        return path;
    }

    protected void onRestart() {
        mAdapter.update();
        super.onRestart();
    }



    /** 拍照 */
    public void photo() {
        // 随机缓存照片名
        mImageFileName = FileUtils.getFileNameForSystemTime(".jpg");
        // 首先判断SD卡是否存在
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment.getExternalStorageDirectory(),mImageFileName)));
            startActivityForResult(intent, TAKE_PICTURE);
        }else{
            ToastUtils.showToast(this, "内存卡不存在");
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            // 拍照
            if(requestCode == TAKE_PICTURE){
                if (Bimp.mDrr.size() < 9 && resultCode == -1) {
                    File file = new File(Environment.getExternalStorageDirectory() + "/" + mImageFileName);
                    mImagePath = file.getPath();
                    Bimp.mDrr.add(mImagePath);
                }
            }
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,int after) {}

    public void strat(){
        list = new ArrayList<String>();
        for (int i = 0; i < Bimp.mDrr.size(); i++) {
//            String  Str = url.substring(url.indexOf(",")+1,url.indexOf("."));
            String Str = Bimp.mDrr.get(i).substring(Bimp.mDrr.get(i).lastIndexOf("/") + 1, Bimp.mDrr.get(i).lastIndexOf("."));
            list.add(FileUtils.SDPATH + Str+".JPEG");
        }
        // 高清的压缩图片全部就在  list 路径里面了
        // 高清的压缩过的 bmp 对象  都在 Bimp.mBmps里面
        // 完成上传服务器后删除缓存
        FileUtils.deleteDir();
        list.clear();
        Bimp.mBmps.clear();
        Bimp.mDrr.clear();
        Bimp.mMax = 0;
    }

    List <String> listurl ;
    public  void uploadFile(Bitmap bm) {
        if (listurl==null){
             listurl = new  ArrayList<String>();
        }
        String url = Bitmap2StrByBase64(bm);
        listurl.add(url);
    }

    public String Bitmap2StrByBase64(Bitmap bit){
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        bit.compress(Bitmap.CompressFormat.JPEG, 40, bos);//参数100表示不压缩
        byte[] bytes=bos.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        int length = etEssay.getText().toString().length();
        mHintView.setVisibility(length >= 1 ? View.VISIBLE : View.GONE);
        mHintView.setTextColor(length < MAX_INPUT_LENGTH ? Color.BLACK : Color.RED);
        mHintView.setText(String.valueOf(MAX_INPUT_LENGTH - length));
    }
    @Override
    public void afterTextChanged(Editable s) {}
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    protected void onLeftImageViewClick(View view) {}

    public void GetReleaseTribune(){
        String setprov = "直辖市";
        String setcity = "上海市";
        String setarea = "闵行区";
        String setaddress = "万科时代广场";
        String settitle=etTitle.getText().toString();
        String setcomment=etEssay.getText().toString();
        String Userid=sharedHelper.ReadData("String","Userid").toString();
//        String urls = sb.toString();
        XutilsClass.getInstance().getReleaseTribune(Userid,settitle,setcomment,
                setprov,setcity,setarea,
                setaddress,listurl,
                new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String s) {
                        Log.e("GetReleaseTribune==",s);
                        Gson gson = new Gson();
                        TribuneUp tribuneUp =gson.fromJson(s,TribuneUp.class);
                        if (tribuneUp.getStatus()==200){
                            finish();
                            AbToastUtil.showToast(PostTribuneDateActivity.this,"上传成功");
                        }else {
                            Toast.makeText(PostTribuneDateActivity.this,"上传失败"+tribuneUp.getMessage(),Toast.LENGTH_SHORT);
                        }
                    }
                    @Override
                    public void onError(Throwable throwable, boolean b) {
                        Log.e("GetReleaseTribune失败",throwable.toString());
                    }
                    @Override
                    public void onCancelled(CancelledException e) {
                    }
                    @Override
                    public void onFinished() {
                    }
                });
    }
    public static void hideSystemKeyBoard(Context context, View v) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }


}
