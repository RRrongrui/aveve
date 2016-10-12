package spfworld.spfworld.fragment.find.store;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import spfworld.spfworld.R;
import spfworld.spfworld.activity.StoreDetailActivity;
import spfworld.spfworld.entity.Content;

/**
 * Created by guozhengke on 2016/9/26.
 * 链接web页
 */
public class LinkWebViewFragment extends Fragment{
    @ViewInject(R.id.store_webview)
    private WebView store_webview;
    @ViewInject(R.id.link_back)
    private ImageView link_back;

    private Handler handler;

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden==false){
            init();//加载webviw页面
        }
    }

    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.store_link_webview,container,false);
        x.view().inject(this,view);
        //监听返回键
        link_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StoreDetailActivity storeDetailActivity= (StoreDetailActivity) getActivity();
                handler=storeDetailActivity.handler;
                Message message=new Message();
                message.what=0;
                handler.sendMessage(message);
            }
        });
        return view;
    }
    //加载web页面
    private void init() {
        store_webview.loadUrl(Content.link_web);
        store_webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        //启用支持javascript
        WebSettings settings = store_webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
    }
}
