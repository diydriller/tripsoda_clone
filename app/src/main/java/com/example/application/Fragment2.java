package com.example.application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment2 extends Fragment {

    public static Fragment2 newInstance(){
        return new Fragment2();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_fragment2, container, false);



        Bundle bundle = getArguments();
        int locationId = bundle.getInt("locationId");

        ArrayList<TripItem> list=new ArrayList<TripItem>();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dhrhd080.cafe24.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Service service=retrofit.create(Service.class);
        HashMap<String,Object> input=new HashMap<>();
        input.put("locationId",locationId+"");

        service.createPost2(input).enqueue(new Callback<List<Page2Info>>() {
            @Override
            public void onResponse(Call<List<Page2Info>> call, Response<List<Page2Info>> response) {
                List<Page2Info> PostResponse=response.body();

                int cnt_list=PostResponse.size();

                for(int i=0;i<cnt_list;i++){
                    Page2Info tmpObj=PostResponse.get(i);
                    list.add(new TripItem(tmpObj.getTourName(),tmpObj.getTourMonth(),tmpObj.getTourDay(),tmpObj.getTourHour(),StringToBitmap(tmpObj.getImage()),tmpObj.getLocationId()));
                }

                RecyclerView rv=rootView.findViewById(R.id.recyclerView);
                rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                RecycleViewAdapter1 adapter=new RecycleViewAdapter1(list);
                rv.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Page2Info>> call, Throwable t) {

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