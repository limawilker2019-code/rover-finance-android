package com.roverfinance.app;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.webkit.ValueCallback;
import android.util.Log;

public class MainActivity extends Activity {
    private WebView webView;
    private BroadcastReceiver receiver;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResources().getIdentifier("activity_main", "layout", getPackageName()));

        int webviewId = getResources().getIdentifier("webview", "id", getPackageName());
        webView = findViewById(webviewId);
        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);

        // load existing asset or index.html
        webView.loadUrl("file:///android_asset/index.html");

        IntentFilter filter = new IntentFilter(NotificationListener.ACTION_NOTIFY_WEBVIEW);
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String payload = intent.getStringExtra("payload");
                if (payload == null) return;
                final String js = "handleNotification(" + JSONObjectEscape(payload) + ");";
                runOnUiThread(() -> {
                    try {
                        webView.evaluateJavascript(js, null);
                    } catch (Exception e) {
                        Log.e(TAG, "evaluateJavascript failed", e);
                    }
                });
            }
        };
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (receiver != null) unregisterReceiver(receiver);
    }

    private String JSONObjectEscape(String json) {
        if (json == null) return "''";
        json = json.replace("\\", "\\\\").replace("'", "\\'").replace("\n", "\\n").replace("\r", "\\r");
        return "'" + json + "'";
    }
}
