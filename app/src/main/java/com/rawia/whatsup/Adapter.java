package com.rawia.whatsup;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    ArrayList<ImfCatagory> arrayList;
    Context mContext;

    public Adapter(ArrayList<ImfCatagory> arrayList, Context mContext) {
        this.arrayList = arrayList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.mName.setText(arrayList.get(position).getmName());
        holder.mimg.setImageResource(arrayList.get(position).getmImg());
        holder.mimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext , ImgProfile.class)
                        .putExtra("image" , arrayList.get(position).getmImg())
              .putExtra("name_user",arrayList.get(position).getmName()));


            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mimg ;
        TextView mName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mimg = itemView.findViewById(R.id.profile_image);
            mName = itemView.findViewById(R.id.nam_user);

        }
    }
}
