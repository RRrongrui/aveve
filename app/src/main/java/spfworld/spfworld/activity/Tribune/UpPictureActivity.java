package spfworld.spfworld.activity.Tribune;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.xutils.x;

import java.io.ByteArrayOutputStream;
import java.io.File;

import ab.util.AbImageUtil;
import spfworld.spfworld.R;

/**
 * Created by Administrator on 2016/9/13.
 */
public class UpPictureActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String IMAGE_UNSPECIFIED = "collont_item/*";
    private static final int PHOTO_RESOULT = 4;

    private Button album, camera;
    private ImageView display;

    private static final String TAG = "MyActivity";

    private static final int ALBUM_REQUEST_CODE = 1;
    private static final int CAMERA_REQUEST_CODE = 2;
    private static final int CROP_REQUEST_CODE = 4;

    private Uri imageUri;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uppicture);
        x.view().inject(this);

        init();
    }

    private void init() {
        album = (Button) findViewById(R.id.ablum_btn);
        camera = (Button) findViewById(R.id.camera_btn);

        display = (ImageView) findViewById(R.id.display_iv);

        album.setOnClickListener(this);
        camera.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.ablum_btn:
                Log.i(TAG, "相册");
                Intent intent = new Intent(Intent.ACTION_PICK, null);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_UNSPECIFIED);
                startActivityForResult(intent, ALBUM_REQUEST_CODE);
                break;
            case R.id.camera_btn:
                Log.i(TAG, "相机");
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment.
                        getExternalStorageDirectory(), "temp.jpg")));
                startActivityForResult(intent, CAMERA_REQUEST_CODE);
                break;
        }
    }

    /**
     * 开始裁剪
     *
     * @param uri
     */
    String imagePath;
    private void startCrop(Uri uri) {
        imagePath = AbImageUtil.getPath(uri,this);
        Intent intent = new Intent("com.android.camera.action.CROP");//调用Android系统自带的一个图片剪裁页面,
        intent.setDataAndType(uri, IMAGE_UNSPECIFIED);
        intent.putExtra("crop", "true");//进行修剪
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 500);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_REQUEST_CODE);
    }

    /**
     * 判断sdcard卡是否可用
     *
     * @return 布尔类型 true 可用 false 不可用
     */
    private boolean isSDCardCanUser() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case ALBUM_REQUEST_CODE:
                Log.i(TAG, "相册，开始裁剪");
                Log.i(TAG, "相册 [ " + data + " ]");
                if (data == null) {
                    return;
                }
                startCrop(data.getData());
                break;
            case CAMERA_REQUEST_CODE:
                Log.i(TAG, "相机, 开始裁剪");
                File picture = new File(Environment.getExternalStorageDirectory()
                        + "/temp.jpg");
                startCrop(Uri.fromFile(picture));
                break;
            case CROP_REQUEST_CODE:
                Log.i(TAG, "相册裁剪成功");
                Log.i(TAG, "裁剪以后 [ " + data + " ]");
                if (data == null) {
                    // TODO 如果之前以后有设置过显示之前设置的图片 否则显示默认的图片
                    return;
                }
                Bundle extras = data.getExtras();
                if (extras != null) {
                    Bitmap photo = extras.getParcelable("data");
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    photo.compress(Bitmap.CompressFormat.JPEG, 75, stream);// (0-100)压缩文件
                    //此处可以把Bitmap保存到sd卡中
                    display.setImageBitmap(photo); //把图片显示在ImageView控件上
                }
                break;
            default:
                break;
        }
    }


//    private static String requestURL = "http://m.yundiaoke.cn/api/comments/message";





//        XutilsClass.getInstance().getReleaseTribune(new Callback.CacheCallback<String>() {
//            @Override
//            public boolean onCache(String s) {
//                return false;
//            }
//            @Override
//            public void onSuccess(String s) {
//                Log.i(TAG,"chenggong.....");
//                AbLogUtil.i("oye",s);
//                AbToastUtil.showToast(UpPictureActivity.this,s);
//            }
//            @Override
//            public void onError(Throwable throwable, boolean b) {
//                Log.i(TAG,"shibaile");
//                AbToastUtil.showToast(UpPictureActivity.this,throwable.getMessage());
//            }
//            @Override
//            public void onCancelled(CancelledException e) {
//
//            }
//
//            @Override
//            public void onFinished() {
//
//            }
//        });
//        RequestParams params = new RequestParams(requestURL);
//        String string = Bitmap2StrByBase64(bm);
//        if (TextUtils.isEmpty(string)){
//            return;
//        }
//        params.addParameter("URL",string);
//        x.http().post(params, new Callback.CommonCallback<String>() {
//            @Override
//            public void onSuccess(String s) {
//                AbLogUtil.i("oye",s);
//                AbToastUtil.showToast(UpPictureActivity.this,s);
//            }
//
//            @Override
//            public void onError(Throwable throwable, boolean b) {
//                AbToastUtil.showToast(UpPictureActivity.this,throwable.getMessage());
//            }
//
//            @Override
//            public void onCancelled(CancelledException e) {
//
//            }
//
//            @Override
//            public void onFinished() {
//
//            }
//        });







}
