package com.roverfinance.app;

import android.app.Notification;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.content.Intent;
import android.util.Log;

import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotificationListener extends NotificationListenerService {
    private static final String TAG = "RoverNotificationListener";
    public static final String ACTION_NOTIFY_WEBVIEW = "com.roverfinance.app.NOTIFICATION_RECEIVED";

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        Notification n = sbn.getNotification();
        if (n == null) return;
        Bundle extras = n.extras;
        String title = extras.getString(Notification.EXTRA_TITLE);
        CharSequence textCs = extras.getCharSequence(Notification.EXTRA_TEXT);
        String text = textCs == null ? "" : textCs.toString();
        CharSequence bigTextCs = extras.getCharSequence(Notification.EXTRA_BIG_TEXT);
        String bigText = bigTextCs == null ? "" : bigTextCs.toString();

        String content = (title == null ? "" : title) + " " + text + " " + bigText;

        // Extrair valores monetários (ex: R$ 12,34 ou 12.34)
        Pattern p = Pattern.compile("(R\\$\\s?)?\\d{1,3}(?:[.,]\\d{3})*(?:[.,]\\d{2})");
        Matcher m = p.matcher(content);

        if (m.find()) {
            String rawAmount = m.group().replaceAll("\\s+", "");
            String normalized = rawAmount.replace("R$", "").replace(".", "").replace(",", ".");
            double amount = 0;
            try { amount = Double.parseDouble(normalized); }
            catch (Exception e) { Log.w(TAG, "parse amount failed", e); }

            try {
                JSONObject payload = new JSONObject();
                payload.put("title", title == null ? "" : title);
                payload.put("text", text);
                payload.put("big_text", bigText);
                payload.put("amount_raw", rawAmount);
                payload.put("amount", amount);
                payload.put("package", sbn.getPackageName());

                Intent i = new Intent(ACTION_NOTIFY_WEBVIEW);
                i.putExtra("payload", payload.toString());
                sendBroadcast(i);

                Log.d(TAG, "notification payload sent: " + payload.toString());
            } catch (Exception e) {
                Log.e(TAG, "error building payload", e);
            }
        }
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        // not used
    }
}
