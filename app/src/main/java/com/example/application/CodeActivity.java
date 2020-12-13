package com.example.application;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class CodeActivity extends AppCompatActivity {
    boolean validate=false;
    private static final String TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);

        TextView phoneNumber=(TextView)findViewById(R.id.phoneNumber);
        TextView emailString=(TextView)findViewById(R.id.emailString);


        EditText codeText=(EditText)findViewById(R.id.codeText);
        codeText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){


                    Response.Listener<String> responseListener=new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d(TAG,"접속");
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if (success) {
                                    AlertDialog dialog;
                                    AlertDialog.Builder builder = new AlertDialog.Builder(CodeActivity.this);
                                    dialog = builder.setMessage("사용할 수 있는 코드")
                                            .setPositiveButton("확인", null)
                                            .create();
                                    dialog.show();
                                    validate = true;
                                    Log.d(TAG, "성공");
                                }
                                else{
                                    AlertDialog dialog;
                                    AlertDialog.Builder builder = new AlertDialog.Builder(CodeActivity.this);
                                    dialog = builder.setMessage("실패")
                                            .setNegativeButton("확인", null)
                                            .create();
                                    dialog.show();
                                    Log.d(TAG, "실패2");
                                }

                            }
                            catch(Exception e){
                                e.printStackTrace();
                                Log.d(TAG,"실패3");
                            }
                        }
                    };
                    Log.d(TAG, "요청");

                    CodeValidateRequest codeValidateRequest=new CodeValidateRequest(codeText.getText().toString(),responseListener);
                    RequestQueue queue = Volley.newRequestQueue(CodeActivity.this);
                    queue.add(codeValidateRequest);



                }
                return true;
            }
        });
    }


    public void openDial(View view){
        Intent dial =new Intent(Intent.ACTION_DIAL);
        dial.setData(Uri.parse("tel:821066097177"));
        startActivity(dial);
    }
    public void openMail(View view){
        Intent email =new Intent(Intent.ACTION_SEND);
        email.setType("text/html");
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@tripsoda.com"});
        email.setPackage("com.google.android.gm");
        startActivity(email);
    }
}