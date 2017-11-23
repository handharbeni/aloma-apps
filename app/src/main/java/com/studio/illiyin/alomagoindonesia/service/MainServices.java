package com.studio.illiyin.alomagoindonesia.service;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.pddstudio.preferences.encrypted.EncryptedPreferences;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by root on 8/28/17.
 */

public class MainServices extends Service {
    public static Boolean serviceRunning = false;
    public static final long NOTIFY_INTERVAL = 5 * 1000;
    private Handler handler = new Handler();
    private Timer timer = null;
    EncryptedPreferences encryptedPreferences;
    @Override
    public void onCreate() {
        encryptedPreferences = new EncryptedPreferences.Builder(this).withEncryptionPassword("password").build();

        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimeDisplayTimerTask(), 0, NOTIFY_INTERVAL);
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        serviceRunning = true;
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        serviceRunning = false;
        super.onDestroy();
    }
    private boolean checkIsRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager
                .getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
    private String checkProvider(){
        TelephonyManager telephonyManager = ((TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE));
        String simOperatorName = telephonyManager.getSimOperatorName();
        return simOperatorName;
    }
    class TimeDisplayTimerTask extends TimerTask {
        @Override
        public void run() {
            handler.post(new Runnable() {
                @Override
                public void run() {
//                    Toast.makeText(MainServices.this, checkProvider(), Toast.LENGTH_SHORT).show();
                    encryptedPreferences.edit().putString("PROVIDER",checkProvider()).apply();
                }
            });
        }
    }
}
