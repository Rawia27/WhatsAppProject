package com.rawia.whatsup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SecAdapter extends RecyclerView.Adapter<SecAdapter.SecMyViewHolder> {
    ArrayList<CallCatagory> list;
    Context sContext;

    public SecAdapter(ArrayList<CallCatagory> list, Context sContext) {
        this.list = list;
        this.sContext = sContext;
    }

    @NonNull
    @Override
    public SecMyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View sview = LayoutInflater.from(parent.getContext()).inflate(R.layout.sec_rec_item, parent, false);
        SecMyViewHolder mySecViewHolder = new SecMyViewHolder(sview);
        return mySecViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SecMyViewHolder holder, int position) {
        holder.sImgUser.setImageResource(list.get(position).getImgUser());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SecMyViewHolder extends RecyclerView.ViewHolder {
        ImageView sImgUser;
        public SecMyViewHolder(@NonNull View itemView) {
            super(itemView);
            sImgUser = itemView.findViewById(R.id.user_img);

        }
    }
}
