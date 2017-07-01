package com.example.android.webbrowser;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    WebView brow;
    EditText urlloader;
    Button go, forward, back, clear, reload;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        brow = (WebView) findViewById(R.id.wv_brow);
    progressBar=(ProgressBar)findViewById(R.id.progressbar);
        urlloader = (EditText) findViewById(R.id.et_url);
        go = (Button) findViewById(R.id.btn_go);
        forward = (Button) findViewById(R.id.btn_fw);
        back = (Button) findViewById(R.id.btn_bw);
        clear = (Button) findViewById(R.id.btn_cl);
        reload = (Button) findViewById(R.id.btn_re);


        String url1="http://www.google.com";
        brow.loadUrl(url1);

        brow.setWebViewClient(new ourViewClient());
        brow.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setProgress(newProgress);
                if(newProgress==100){
                    progressBar.setVisibility(View.GONE);
                }
                else{
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

        WebSettings webSettings = brow.getSettings();
        webSettings.setJavaScriptEnabled(true);

        go.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String edittextvalue = urlloader.getText().toString();

                if (!edittextvalue.startsWith("http://"))
                    edittextvalue = "http://" + edittextvalue;


                String url = edittextvalue;
                brow.loadUrl(url);

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(urlloader.getWindowToken(), 0);

            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (brow.canGoForward())
                    brow.goForward();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (brow.canGoBack())
                    brow.goBack();

            }
        });
        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                brow.reload();
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                brow.clearHistory();
            }
        });


    }
}
