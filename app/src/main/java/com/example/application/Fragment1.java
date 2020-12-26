package com.example.application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class Fragment1 extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_fragment1, container, false);


        Bundle bundle = getArguments();
        int userId = bundle.getInt("userId");

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
                    list.add(new TripItem(tmpObj.getLocationName(),tmpObj.getMonth(),tmpObj.getDay(),tmpObj.getHour(),StringToBitmap(tmpObj.getImage()),tmpObj.getLocationId()));
                }

                RecyclerView rv=rootView.findViewById(R.id.recyclerView);

                rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                RecycleViewAdapter1 adapter=new RecycleViewAdapter1(list);




                Button sortButton = (Button)rootView.findViewById(R.id.sortButton);
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


                adapter.setOnItemClickListener(new RecycleViewAdapter1.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int pos) {
                        ((MyPage1)getActivity()).replaceFragment2(Fragment2.newInstance(),list.get(pos).getLocationId());
                    }
                });


                Button backButton = (Button)rootView.findViewById(R.id.backButton);
                backButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ((MyPage1)getActivity()).onBackPressed();

                    }
                });

            }

            @Override
            public void onFailure(Call<List<Page1Info>> call, Throwable t) {

            }
        });




        return rootView;

    }



    public static Bitmap StringToBitmap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }



}