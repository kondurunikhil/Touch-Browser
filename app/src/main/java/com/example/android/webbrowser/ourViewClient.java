package com.example.android.webbrowser;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Nikhil on 01-07-2017.
 */

public class ourViewClient extends WebViewClient {
@SuppressWarnings("deprecation")
@Override

//better than this available but not all devices are there
    public boolean shouldOverrideUrlLoading(WebView view,String url) {
    view.loadUrl(url);
    return true;


}




}



