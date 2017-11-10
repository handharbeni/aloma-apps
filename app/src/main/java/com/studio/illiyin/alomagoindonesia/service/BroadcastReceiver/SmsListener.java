package com.studio.illiyin.alomagoindonesia.service.BroadcastReceiver;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

import com.studio.illiyin.alomagoindonesia.utils.SMSUtils;

import static android.content.ContentValues.TAG;

/**
 * Created by root on 11/7/17.
 */

public class SmsListener extends BroadcastReceiver {

    private SharedPreferences preferences;

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            Bundle bundle = intent.getExtras();           //---get the SMS message passed in---
            SmsMessage[] msgs = null;
            String msg_from;
            if (bundle != null){
                //---retrieve the SMS message received---
                try{
                    Object[] pdus = (Object[]) bundle.get("pdus");
                    msgs = new SmsMessage[pdus.length];
                    for(int i=0; i<msgs.length; i++){
                        msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                        msg_from = msgs[i].getOriginatingAddress();
                        String msgBody = msgs[i].getMessageBody();
                        Log.d(TAG, "onReceive: SMS Listener "+msg_from+" "+msgBody);
                        String cs = "";
                        String message = "";
                        switch (msg_from){
                            case "151" :
                                cs = "151";
                                String[] submessage = msgs[i].getMessageBody().toString().split(" adalah token anda. ");
                                message = "Ok "+submessage[0];
//                                SMSUtils.sendSMS(context, cs, message);
                                sentSMS(context, cs, message);
                                Log.d(TAG, "onReceive: SMS Listener "+msg_from+" "+message);
                                break;
                            case "858" :
                                cs = "858";
                                message = "YA";
//                                SMSUtils.sendSMS(context, cs, message);
                                sentSMS(context, cs, message);
                                Log.d(TAG, "onReceive: SMS Listener "+msg_from+" "+message);
                                break;
                            case "168" :
                                cs = "168";
                                message = "Y";
//                                SMSUtils.sendSMS(context, cs, message);
                                sentSMS(context, cs, message);
                                Log.d(TAG, "onReceive: SMS Listener "+msg_from+" "+message);
                                break;
                        }
                    }
                }catch(Exception e){
//                            Log.d("Exception caught",e.getMessage());
                }
            }
        }
    }
    private void sentSMS(Context context, String destination, String message){
        SmsManager smsManager = SmsManager.getDefault();
        Intent intent = new Intent();
        PendingIntent sentIntent = PendingIntent.getBroadcast(context, 0,
                intent, 0);
//        SMSForwarderApp.getAppContext().registerReceiver(
//                new MessageSentListener(),
//                new IntentFilter(SENT_SMS_FLAG));
        smsManager.sendTextMessage(destination, null,
                message, sentIntent, null);
    }
}