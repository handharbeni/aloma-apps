package com.studio.illiyin.alomagoindonesia.MenuTab;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.studio.illiyin.alomagoindonesia.Generator.ServiceGenerator;
import com.studio.illiyin.alomagoindonesia.R;
import com.studio.illiyin.alomagoindonesia.fragment.Home;
import com.studio.illiyin.alomagoindonesia.service.RrequestInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by Mindha on 21/06/2017.
 */

public class SignIn extends Fragment {
    public static String KEY_ID = "id";
    public static String UNIQ_KEY ="uniq_key";
    View myView;
    private EditText txtUsername, txtPassword;
    private Button btnLogin;
    ProgressDialog loading;

    Context mContext;
    RrequestInterface request;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_sign_in,container,false);

        //binding
        txtUsername = myView.findViewById(R.id.username);
        txtPassword = myView.findViewById(R.id.password);
        btnLogin = myView.findViewById(R.id.btn_login);

        mContext = getContext();
        request = ServiceGenerator.createService(RrequestInterface.class);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loading = ProgressDialog.show(getActivity(), null, "Please Wait", true, false);
                requestLogin();

            }
        });
        return myView;
    }

    private void requestLogin() {
        request.loginRequest(txtUsername.getText().toString(),
                txtPassword.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccessful()){
                            loading.dismiss();

                            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                            Fragment fragment = new Home();
                            ft.replace(R.id.container, fragment);
                            ft.commit();

                            Toast.makeText(mContext, "Berhasil Login", Toast.LENGTH_SHORT).show();
//                            try{
//                                JSONObject jsonResult = new JSONObject(response.body().string());
//                                if(jsonResult.getString("error").equals(false)){
////                                    JSONArray array = jsonResult.getJSONArray("data");
////                                    if (array.length() > 0){
////                                        for (int i=0;i<array.length();i++){
////                                            JSONObject object = array.getJSONObject(i);
////                                            String id = jsonResult.getString("id");
////
////                                            SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
////                                            SharedPreferences.Editor editor = sharedPreferences.edit();
////                                            editor.putString(UNIQ_KEY,id);
////                                            editor.commit();
////
//
//
////                                            Toast.makeText(getContext(), "test"+editor.commit(), Toast.LENGTH_SHORT).show();
////                                        }
////                                    }
//                                    Toast.makeText(mContext, "BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
//                                }else {
//                                    String error_message = jsonResult.getString("error_msg");
//                                    Toast.makeText(mContext, error_message,Toast.LENGTH_SHORT).show();
//                                }
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
                        }else {
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "Error"+t.toString());
                        loading.dismiss();
                    }
                });
    }
}
