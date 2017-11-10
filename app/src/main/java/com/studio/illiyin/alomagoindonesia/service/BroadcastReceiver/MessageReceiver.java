package com.studio.illiyin.alomagoindonesia.service.BroadcastReceiver;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import com.pddstudio.preferences.encrypted.EncryptedPreferences;

import static android.content.ContentValues.TAG;

/**
 * Created by root on 8/28/17.
 */

public class MessageReceiver extends android.content.BroadcastReceiver {
    EncryptedPreferences encryptedPreferences;

    @Override
    public void onReceive(Context context, Intent intent)
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        encryptedPreferences = new EncryptedPreferences.Builder(context).withEncryptionPassword("password").build();
        //---get the SMS message passed in---
        Bundle bundle = intent.getExtras();
        SmsMessage[] msgs = null;
        String str = "";
        if (bundle != null)
        {
            String provider = encryptedPreferences.getString("PROVIDER", "na");
            //---retrieve the SMS message received---
            Object[] pdus = (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];
//            Log.d(TAG, "onReceive: "+String.valueOf(msgs.length));
//            Log.d(TAG, "onReceive: "+msgs[msgs.length-1]);
//            String cs = "";
//            String message = "";
            for (int i=0; i<msgs.length; i++){
//                Log.d(TAG, "onReceive: "+msgs[i].getOriginatingAddress());
//                085941020493
//                msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
//                String sProvider = encryptedPreferences.getString("providers", "m3");
//                switch (sProvider){
//                    case "m3" :
//                        cs = "151";
//                        String[] submessage = msgs[i].getMessageBody().toString().split(" adalah token anda. ");
//                        message = "Ok "+submessage[0];
//                        break;
//                    case "telkomsel" :
//                        cs = "858";
//                        message = "YA";
//                        break;
//                    case "xl" :
//                        cs = "168";
//                        message = "Y";
//                        break;
//                }
//                if (cs.equalsIgnoreCase(msgs[i].getOriginatingAddress())){
//                    sendMessage(cs, message);
//                }
//                str += "SMS from " + msgs[i].getOriginatingAddress();
//                str += " :";
//                str += msgs[i].getMessageBody().toString();
//                str += "n";
            }
            //---display the new SMS message---
//            Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
        }
    }
    private void sendMessage(String phoneNo, String message){
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
