package com.example.hiraganamaster;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class Notification extends Application {
    public static final String CHANNEL_1_ID = "appnotification";
    public static final String CHANNEL_2_ID = "appnotification";

    public void onCreate()
    {
        super.onCreate();

        createNotificationChannels();
    }
    private void createNotificationChannels()
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Hiragana Master Notification",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channel1.setDescription("This is Hiragana Master's notification");

            NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_2_ID,
                    "Hiragana Master Notification",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel2.setDescription("This is Hiragana Master's notification");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
        }
    }
}
