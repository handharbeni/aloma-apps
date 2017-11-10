package com.studio.illiyin.alomagoindonesia.MenuTab;

import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.pddstudio.preferences.encrypted.EncryptedPreferences;
import com.studio.illiyin.alomagoindonesia.R;
import com.studio.illiyin.alomagoindonesia.utils.SMSUtils;

import java.io.IOException;

import illiyin.mhandharbeni.httpcalllibrary.AndroidCall;

/**
 * Created by Mindha on 16/06/2017.
 */

public class TransferPulsa extends Fragment{
    private static final String TAG = "TransferPulsa";
    EncryptedPreferences encryptedPreferences;
    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        encryptedPreferences = new EncryptedPreferences.Builder(getActivity().getApplicationContext()).withEncryptionPassword("password").build();

        myView = inflater.inflate(R.layout.fragment_transfer_pulsa,container,false);
        dropdownList(myView);

//        ImageView lineColorCode = (ImageView)myView.findViewById(R.id.icon_transfer_bak);
        int color = Color.parseColor("#BDBDBD"); //The color u want
//        lineColorCode.setColorFilter(color);

        ImageView imageView = (ImageView) myView.findViewById(R.id.icon_transfer);
        imageView.setColorFilter(color);
        AppCompatButton send = (AppCompatButton) myView.findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doTransfer();
            }
        });
        return myView;
    }

    public void dropdownList(View view){
        Spinner dynamicSpinner = (Spinner) view.findViewById(R.id.denominasi);

        String[] items = new String[] { "5000", "10000", "15000" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, items);

        dynamicSpinner.setAdapter(adapter);



        dynamicSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });


    }


    protected void sendSMSMessage(String phoneNo, String message) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getActivity().getApplicationContext(), "SMS sent.",
                    Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getActivity().getApplicationContext(),
                    "SMS failed, please try again.",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
    private void doTransfer(){
        String destNumber = "", message = "";
        EditText nomor_origin = (EditText) myView.findViewById(R.id.nomor_origin);
        EditText nomor_tujuan = (EditText) myView.findViewById(R.id.nomor_tujuan);
        Spinner nominal = (Spinner) myView.findViewById(R.id.denominasi);


        int iNominal = Integer.valueOf(nominal.getSelectedItem().toString());
        int TotalJasa = 2000;
        int totalTransfer = iNominal+TotalJasa;

        if (!nomor_origin.getText().toString().equalsIgnoreCase("") && !nomor_origin.getText().toString().equalsIgnoreCase("")){
            String provider = getProvider(nomor_origin.getText().toString());
            Toast.makeText(getActivity().getApplicationContext(), "MAU KIRIM "+provider, Toast.LENGTH_SHORT).show();
            switch (provider){
                case "m3" :
                    Toast.makeText(getActivity().getApplicationContext(), "SENDING M3", Toast.LENGTH_SHORT).show();
                    destNumber = "151";
                    message = "TransferPulsa 085732694628 "+String.valueOf(totalTransfer);
                    SMSUtils.sendSMS(getActivity().getApplicationContext(), destNumber, message);
                    sentKonfirmToServer(nomor_origin.getText().toString(), nomor_tujuan.getText().toString(), nominal.getSelectedItem().toString(), String.valueOf(totalTransfer));
                    break;
                case "telkomsel" :
                    destNumber = "082143434808";
                    message = "TPULSA "+String.valueOf(totalTransfer);
                    SMSUtils.sendSMS(getActivity().getApplicationContext(), destNumber, message);
//                    sendSMSMessage(destNumber, message);
                    sentKonfirmToServer(nomor_origin.getText().toString(), nomor_tujuan.getText().toString(), nominal.getSelectedItem().toString(), String.valueOf(totalTransfer));
                    break;
                case "XL Axiata":
                    destNumber = "168";
                    message = "BAGI 083856160083 "+String.valueOf(totalTransfer);
                    SMSUtils.sendSMS(getActivity().getApplicationContext(), destNumber, message);
//                    sendSMSMessage(destNumber, message);
                    sentKonfirmToServer(nomor_origin.getText().toString(), nomor_tujuan.getText().toString(), nominal.getSelectedItem().toString(), String.valueOf(totalTransfer));
                    break;
                case "XL 4G LTE" :
                    destNumber = "168";
                    message = "BAGI 083856160083 "+String.valueOf(totalTransfer);
                    SMSUtils.sendSMS(getActivity().getApplicationContext(), destNumber, message);
//                    sendSMSMessage(destNumber, message);
                    sentKonfirmToServer(nomor_origin.getText().toString(), nomor_tujuan.getText().toString(), nominal.getSelectedItem().toString(), String.valueOf(totalTransfer));
                    break;
                case "three" :
                    destNumber = "123";
                    message = "TRANSFER "+totalTransfer+" 089684503715";
                    SMSUtils.sendSMS(getActivity().getApplicationContext(), destNumber, message);
//                    sendSMSMessage(destNumber, message);
                    sentKonfirmToServer(nomor_origin.getText().toString(), nomor_tujuan.getText().toString(), nominal.getSelectedItem().toString(), String.valueOf(totalTransfer));
                    break;
                case "ceria" :
                    destNumber = nomor_tujuan.getText().toString();
                    message = "TRANSFERPULSA ";
                    SMSUtils.sendSMS(getActivity().getApplicationContext(), destNumber, message);
//                    sendSMSMessage(destNumber, message);
                    sentKonfirmToServer(nomor_origin.getText().toString(), nomor_tujuan.getText().toString(), nominal.getSelectedItem().toString(), String.valueOf(totalTransfer));
                    break;
                case "smart" :
                    destNumber = nomor_tujuan.getText().toString();
                    message = "TRANSFERPULSA ";
                    SMSUtils.sendSMS(getActivity().getApplicationContext(), destNumber, message);
//                    sendSMSMessage(destNumber, message);
                    sentKonfirmToServer(nomor_origin.getText().toString(), nomor_tujuan.getText().toString(), nominal.getSelectedItem().toString(), String.valueOf(totalTransfer));
                    break;
            }
        }
    }
    private void sentKonfirmToServer(String phoneOrigin, String phoneDest, String denominasi, String totalTransfer){
        String endpoint = getString(R.string.endpointUri)+"sentKonfirm/"+phoneOrigin+"/"+phoneDest+"/"+denominasi+"/"+totalTransfer;
        AndroidCall androidCall = new AndroidCall(getActivity().getApplicationContext());
        try {
            androidCall.get(endpoint);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String getProvider(String phoneNumber){
        String provider = "";
        String endpoint = getString(R.string.endpointUri)+"getCodePhoneNumber/"+phoneNumber;
        AndroidCall androidCall = new AndroidCall(getActivity().getApplicationContext());
        try {
            String response = androidCall.get(endpoint);
            provider = response;
            encryptedPreferences.edit().putString("providers", provider).apply();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return provider;
    }
}
