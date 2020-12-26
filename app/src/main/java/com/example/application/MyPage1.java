package com.example.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyPage1 extends AppCompatActivity {

    public void replaceFragment2(Fragment2 fragment,int locationId){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_layout,fragment).commit();

        Bundle bundle=new Bundle();
        bundle.putInt("locationId",locationId);
        fragment.setArguments(bundle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_my_page1);

        Fragment1 fragment1 = new Fragment1();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,fragment1).commitAllowingStateLoss();



        Intent userIntent = getIntent();
        int userId=userIntent.getIntExtra("userId",0);

        Bundle bundle = new Bundle();
        bundle.putInt("userId",userId);
        fragment1.setArguments(bundle);




/*
    ArrayList<TripItem> list=new ArrayList<TripItem>();


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://dhrhd080.cafe24.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    Service service=retrofit.create(Service.class);
    HashMap<String,Object> input=new HashMap<>();
    input.put("userId",userId+"");

    service.createPost1(input).enqueue(new Callback<List<Page1Info>>() {
        @Override
        public void onResponse(Call<List<Page1Info>> call, Response<List<Page1Info>> response) {
            List<Page1Info> PostResponse=response.body();

            int cnt_list=PostResponse.size();

            for(int i=0;i<cnt_list;i++){
                Page1Info tmpObj=PostResponse.get(i);
                list.add(new TripItem(tmpObj.getLocationName(),tmpObj.getMonth(),tmpObj.getDay(),tmpObj.getHour(),StringToBitmap(tmpObj.getImage())));
            }

            RecyclerView rv=findViewById(R.id.recyclerView);
            rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

            RecycleViewAdapter adapter=new RecycleViewAdapter(list);




            Button backButton = (Button)findViewById(R.id.backButton);
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });

            Button sortButton = (Button)findViewById(R.id.sortButton);
            sortButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Comparator<TripItem> noAsc = new Comparator<TripItem>() {
                        @Override
                        public int compare(TripItem item1, TripItem item2) {
                            if(item1.getSum()<item2.getSum()) return -1;
                            else return 1;
                        }
                    };
                    Collections.sort(list,noAsc);
                    adapter.notifyDataSetChanged();
                }
            });
            rv.setAdapter(adapter);



        }

        @Override
        public void onFailure(Call<List<Page1Info>> call, Throwable t) {

        }
    });




*/
            }






        /*
        public static Bitmap StringToBitmap(String encodedString) {
            try {
                byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
                Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
                return bitmap;
            } catch (Exception e) {
                e.getMessage();
                return null;
            }
        }*/

    }