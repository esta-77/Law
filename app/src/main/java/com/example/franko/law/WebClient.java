package com.example.franko.law;

import android.support.v4.widget.SwipeRefreshLayout;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebClient extends WebViewClient {

    private SwipeRefreshLayout refreshLayout;

    public WebClient(SwipeRefreshLayout refreshLayout) {
        this.refreshLayout = refreshLayout;
        this.refreshLayout.setRefreshing(true);
    }



    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        refreshLayout.setRefreshing(false);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
