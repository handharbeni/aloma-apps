package com.studio.illiyin.alomagoindonesia.MenuTab;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.studio.illiyin.alomagoindonesia.Generator.ServiceGenerator;
import com.studio.illiyin.alomagoindonesia.Models.JSONResponse;
import com.studio.illiyin.alomagoindonesia.R;
import com.studio.illiyin.alomagoindonesia.service.RrequestInterface;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mindha on 21/06/2017.
 */

public class SignUp extends Fragment{
    View myView;
    private TextView txtUsername, txtPassword, txtEmail;
    private Button btnRegister;
    ProgressDialog loading;

    Context mContext;
    RrequestInterface request;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_sign_up,container,false);


        //binding
        txtUsername = myView.findViewById(R.id.username);
        txtEmail =myView.findViewById(R.id.email);
        txtPassword = myView.findViewById(R.id.password);
        btnRegister = myView.findViewById(R.id.btn_registrasi);

        mContext = getContext();
        request = ServiceGenerator.createService(RrequestInterface.class);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getActivity(), "Test", Toast.LENGTH_LONG).show();
                loading = ProgressDialog.show(getActivity(), null, "Please Wait", true, false);
                requestReqister();
            }
        });
        return myView;
    }

    private void requestReqister() {
        request.registerRequest(txtUsername.getText().toString(),
                txtPassword.getText().toString(),
                txtEmail.getText().toString()).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            Log.i("debug", "onResponse : BERHASIL");
                            loading.dismiss();
                            try{
                                JSONObject jsonResult = new JSONObject(response.body().string());
                                if(jsonResult.getString("error").equals(false)){
                                    Toast.makeText(getActivity(), "BERHASIL REGISTRASI", Toast.LENGTH_SHORT).show();
                                }else{
                                    String error_message = jsonResult.getString("error_msg");
                                    Toast.makeText(getActivity(), error_message, Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }else {
                            Log.i("debug", "onResponse: REGISTRASI GAGAL");
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR >"+t.getMessage());
                        Toast.makeText(mContext, "Koneksi Bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });
    }


}
