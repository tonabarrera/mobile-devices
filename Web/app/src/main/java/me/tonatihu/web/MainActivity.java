package me.tonatihu.web;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnUno, btnDos, btnTres, btnCuatro;
    WebSettings webSettings;
    WebView webView;
    EditText editText;
    String home = "https://www.google.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUno = findViewById(R.id.btn_uno);
        btnUno.setOnClickListener(this);
        btnDos = findViewById(R.id.btn_dos);
        btnDos.setOnClickListener(this);
        btnTres = findViewById(R.id.btn_tres);
        btnTres.setOnClickListener(this);
        btnCuatro = findViewById(R.id.btn_cuatro);
        btnCuatro.setOnClickListener(this);

        editText = findViewById(R.id.edit_text);

        webView = findViewById(R.id.web_view);
        webView.setWebViewClient(new Cliente());
        webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_uno:
                webView.goBack();
                break;
            case R.id.btn_dos:
                webView.loadUrl(home);
                break;
            case R.id.btn_tres:
                webView.goForward();
                break;
            case R.id.btn_cuatro:
                webView.loadUrl(editText.getText().toString());
                break;
        }
    }

    class Cliente extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            editText.setText(url);
        }
    }
}
