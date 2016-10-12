package spfworld.spfworld.fragment.find.tribune;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.xutils.common.Callback;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

import ab.util.AbLogUtil;
import ab.util.AbToastUtil;
import spfworld.spfworld.R;
import spfworld.spfworld.adapter.Tribune.CommentAdapter;
import spfworld.spfworld.adapter.Tribune.CommentReplyAdapter;
import spfworld.spfworld.adapter.Tribune.GridAdapter2;
import spfworld.spfworld.entity.Tribune.TribnueCommentReplyData;
import spfworld.spfworld.entity.Tribune.TribuneDatail;
import spfworld.spfworld.utils.Contants;
import spfworld.spfworld.utils.SharedHelper;
import spfworld.spfworld.utils.XutilsClass;
import spfworld.spfworld.widget.percent.view.CircleImageView;
import spfworld.spfworld.widget.percent.view.MyListView;

/**bu_topic_finsh
 * iv_share
 * 主题帖
 * Created by Administrator on 2016/9/9.
 */
public class TribuneDatailsFragment extends Fragment{
    ArrayList<TribuneDatail.DataBean> data = new ArrayList<>();
    ArrayList<TribnueCommentReplyData.DataBean> commdata = new ArrayList<>();
    ArrayList<TribnueCommentReplyData.DataBean.CengzhuBean> cengzhuBeanData = new ArrayList<>();
    private View view;
    private static final int ONE_COMMENT_CODE = 1;
    private static final int TWO_COMMENT_CODE = 2;
    @ViewInject(R.id.btn_main_send)
    private Button btn_comment;
    @ViewInject(R.id.lv_tribune_reply)
    private MyListView lv_user_comments;
    private GridView gridView2;
    @ViewInject(R.id.tv_title)
    private TextView tvUser;//用户名
    @ViewInject(R.id.tv_date)
    private TextView tvDateTime;//发帖时间
    @ViewInject(R.id.tv_tribune_title)
    private TextView tvTriTitle;//帖子标题
    @ViewInject(R.id.tv_tribune_data)
    private TextView tvTriData;//帖子内容
    @ViewInject(R.id.iv)
    private CircleImageView userImg;
    @ViewInject(R.id.linearlayout1)
    private SwipeRefreshLayout layout;
    private Context mcontext;
    private CommentAdapter commentAdapter;
    private CommentReplyAdapter commentReplyAdapter;
    private SharedHelper sharedHelper;
    private int uid = 8;
    private int page = 1;
    public String R_id ;
    private boolean flag ;//判断回复楼主或层主

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.item_activity_topic,container,false);
        x.view().inject(this,view);
        sharedHelper=new SharedHelper(getActivity());
        mcontext = getContext();
        gridView2 = (GridView) view.findViewById(R.id.mGrid2);
        GetTribuneData();
        GetTribuneDataComment();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initdata();
    }

    private void initdata() {
        layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh() {
                GetTribuneData();
                GetTribuneDataComment();
            }
        });
    }

    @Event(value={R.id.bu_topic_finsh,R.id.iv_share,R.id.btn_main_send},
            type=View.OnClickListener.class)
    private void mClick(View v){
        switch (v.getId()){
            case R.id.bu_topic_finsh://回退
                getActivity().finish();
                break;
            case R.id.iv_share://分享
                break;
            case R.id.btn_main_send:
                flag = true;
                onCreateDialog(getActivity().getIntent().getStringExtra("id"));
                break;
            default:
                hideSystemKeyBoard(getActivity(),layout);
                break;
        }
    }


//主题帖子详情网络请求
    public void GetTribuneData(){
        XutilsClass.getInstance().getTribuneData(getActivity().getIntent().getStringExtra("id"), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("GetTribuneData成功",s);
                Gson gson = new Gson();
                TribuneDatail tribuneDatail = gson.fromJson(s,TribuneDatail.class);
//                ImageLoad imageLoad=new ImageLoad();
                ImageLoader.getInstance().displayImage(Contants.IMAGE_BASE_URL+tribuneDatail.getData().get(0).getHeadpic(),userImg);
                if (tribuneDatail.getData()!=null&&tribuneDatail.getData().size()>0) {
                    AbLogUtil.i("oye","pic == "+tribuneDatail.getData().get(0).getPic().toString());
                    tvUser.setText(tribuneDatail.getData().get(0).getUsername());
                    tvTriTitle.setText(tribuneDatail.getData().get(0).getTitle());
                    tvTriData.setText(tribuneDatail.getData().get(0).getComment());
                    tvDateTime.setText(tribuneDatail.getData().get(0).getCreated_at());
                    gridView2.setAdapter(new GridAdapter2(getActivity(), tribuneDatail.getData().get(0).getPic()));
                    scrollToTop();
                }
            }
            @Override
            public void onError(Throwable throwable, boolean b) {
                Log.e("GetTribuneData网络请求失败",throwable.toString());
            }
            @Override
            public void onCancelled(CancelledException e) {
            }
            @Override
            public void onFinished() {
            }
        });

    }
//显示层主信息网络请求
    public void GetTribuneDataComment() {
        XutilsClass.getInstance().getTribnueCommentData(getActivity().getIntent().getStringExtra("id"),1+"", new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.e("GetTribuneDataComment==",s);
                Gson gson = new Gson();
                TribnueCommentReplyData tribuneCommentdata = gson.fromJson(s,TribnueCommentReplyData.class);
                if (tribuneCommentdata!=null) {
                    if (tribuneCommentdata.getStatus() == 200) {
                        if (tribuneCommentdata.getData() != null && tribuneCommentdata.getData().size() > 0) {
                            if (page==1){
                                commdata.clear();
                            }
                            commdata.addAll(tribuneCommentdata.getData());
                            AbLogUtil.i("oye",commdata.size()+"    wwwww");
                            commentAdapter = new CommentAdapter(mcontext, commdata);
                            lv_user_comments.setAdapter(commentAdapter);
                            commentAdapter.notifyDataSetChanged();
                            commentAdapter.setCommentCallBack(new CommentAdapter.ICommentCallBack() {
                                @Override
                                public void showCommentPop(int index) {
                                    flag =false;
                                    onCreateDialog(commdata.get(index).getR_id());
                                    R_id = commdata.get(index).getR_id();
                                    AbToastUtil.showToast(getActivity(),index+"");

                                    Log.e("层主ID==",index+"");

                                }
                            });
                            AbLogUtil.i("oye",commdata.size()+"");
                        }
                    }
                }
            }
            @Override
            public void onError(Throwable throwable, boolean b) {
                Log.e("DataComment网络请求失败",throwable.toString());
            }
            @Override
            public void onCancelled(CancelledException e) {
            }
            @Override
            public void onFinished() {
            }
        });

    }

    //回复楼主信息
    private void GetTribuneDataTitle(){
        String Userid=sharedHelper.ReadData("String","Userid").toString();
        String replys = edt_reply.getText().toString();
        XutilsClass.getInstance().getTribuneDataTitle(Userid, getActivity().getIntent().getStringExtra("id"), replys,
                "", new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String s) {
                        Log.i("==回复上传成功",s);
                        Gson gson = new Gson();
                    }
                    @Override
                    public void onError(Throwable throwable, boolean b) {
                        Log.i("==回复上传失败",throwable.toString());
                    }
                    @Override
                    public void onCancelled(CancelledException e) {
                    }
                    @Override
                    public void onFinished() {
                    }
                });
    }
    //回复层主
    private void GetTbeComDataChildTitle(){
        String Userid=sharedHelper.ReadData("String","Userid").toString();
        String r_id_replys = edt_reply.getText().toString();
        XutilsClass.getInstance().getTbeComDataChildTitle(Userid, getActivity().getIntent().getStringExtra("id"), R_id, r_id_replys, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.i("==Child回复上传成功",s);
                Gson gson = new Gson();
            }
            @Override
            public void onError(Throwable throwable, boolean b) {
                Log.i("==Child回复上传失败",throwable.toString());
            }
            @Override
            public void onCancelled(CancelledException e) {
            }
            @Override
            public void onFinished() {
            }
        });
    }

    private LinearLayout ll_comment;
    private Button  btn_reply;
    private EditText  edt_reply;
    private TextView tv_reply;

    protected PopupWindow onCreateDialog(final String id) {

        View view2 = View.inflate(getActivity(),R.layout.dialog_comment, null);
        final PopupWindow customDialog = new PopupWindow(view2, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,true);
        edt_reply = (EditText) view2.findViewById(R.id.edt_comments);
        btn_reply = (Button) view2.findViewById(R.id.btn_send);
        customDialog.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        customDialog.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        customDialog.setContentView(view2);
        customDialog.setFocusable(true); // 获取焦点
        customDialog.setTouchable(true);
        customDialog.setOutsideTouchable(true); // 设置popupwindow外部可点击
        customDialog.showAtLocation(view, Gravity.BOTTOM,0,0);
        btn_reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag ==true){
                    GetTribuneDataTitle();//回复楼主信息
                }else {
                    GetTbeComDataChildTitle();
                }

                customDialog.dismiss();
            }
        });
        customDialog.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                /**** 如果点击了popupwindow的外部，popupwindow也会消失 ****/
                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    customDialog.dismiss();
                    return true;
                }

                return false;
            }
        });
        return customDialog;
    }
    /**
     * 解决scrollview自动滑动问题
     * 让别的控件 获取焦点
     */
    private void scrollToTop() {

        tvUser.setFocusable(true);
        tvUser.setFocusableInTouchMode(true);
        tvUser.requestFocus();
    }
    public static void hideSystemKeyBoard(Context mcontext, View v) {
        InputMethodManager imm = (InputMethodManager) mcontext.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
