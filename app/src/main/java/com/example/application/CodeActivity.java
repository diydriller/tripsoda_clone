package com.example.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CodeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);

        TextView phoneNumber=(TextView)findViewById(R.id.phoneNumber);
        TextView emailString=(TextView)findViewById(R.id.emailString);
        EditText codeText=(EditText)findViewById(R.id.codeText);
        Button backButton=(Button)findViewById(R.id.backButton);







        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        codeText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){

                    //retrofit
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://dhrhd080.cafe24.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    Service service=retrofit.create(Service.class);
                    HashMap<String,Object> input=new HashMap<>();
                    input.put("userCode",codeText.getText().toString());

                    service.createPost(input).enqueue(new Callback<UserInfo>() {
                        @Override
                        public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {

                            UserInfo PostResponse=response.body();
                            boolean success = PostResponse.isSuccess();
                            int userId=PostResponse.getUserId();

                            if (success) {
                                Intent successIntent=new Intent(CodeActivity.this, MyPage1.class);
                                successIntent.putExtra("userId",userId);
                                CodeActivity.this.startActivity(successIntent);
                            }
                            else{
                                Intent failIntent=new Intent(CodeActivity.this, ErrorActivity.class);
                                CodeActivity.this.startActivity(failIntent);
                            }
                        }

                        @Override
                        public void onFailure(Call<UserInfo> call, Throwable t) {
                            Intent failIntent=new Intent(CodeActivity.this, ErrorActivity.class);
                            CodeActivity.this.startActivity(failIntent);
                        }
                    });
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