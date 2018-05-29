package com.thunkable.android.diogo_borbar.EvapoCalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class activityPoliticaPrivacidade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_politica_privacidade);

        WebView webView = (WebView) findViewById(R.id.wv_content);
        webView.loadUrl("https://diogobrodrigues.wordpress.com/politica-de-privacidade-2/");
    }
}

