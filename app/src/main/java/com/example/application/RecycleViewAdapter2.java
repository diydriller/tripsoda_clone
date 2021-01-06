package com.example.application;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;

public class RecycleViewAdapter2 extends RecyclerView.Adapter<RecycleViewAdapter2.ViewHolder> {


    private ArrayList<TripItem> data =null;
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv1;
        TextView tv2;
        ImageView iv1;

        ViewHolder(View v){
            super(v);
            tv1=v.findViewById(R.id.locationText);
            tv2=v.findViewById(R.id.timeText);
            iv1=v.findViewById(R.id.imageView);

        }
    }

    RecycleViewAdapter2(ArrayList<TripItem> list){
        data=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.trip_item, parent, false) ;
        RecycleViewAdapter2.ViewHolder vh = new RecycleViewAdapter2.ViewHolder(view) ;

        return vh ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TripItem el = data.get(position) ;
        holder.tv1.setText(el.getLocation()) ;

        String t1;
        int h=el.getHour();

        if(h>=12&&h<24){
            t1="PM";
            if(h!=12) h-=12;
        }
        else{
            t1="AM";
            if(h==24) h=0;
        }


        holder.tv2.setText(el.getMonth()+"/"+el.getDay()+" - "+t1+" "+h+"시");

        holder.iv1.setImageBitmap(Bitmap.createScaledBitmap(el.getPic(),1000,500,false));



    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
