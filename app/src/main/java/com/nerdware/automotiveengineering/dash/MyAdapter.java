package com.nerdware.automotiveengineering.dash;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nerdware.automotiveengineering.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private final OnItemClickListener mlistener;
    ArrayList<Items> items;
    Activity activity;
    int Counter = 0;
    Context context;

    public MyAdapter(OnItemClickListener listener, ArrayList<Items> items, Context context) {
        this.mlistener = listener;
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {

        holder.imageView.setImageResource(items.get(position).getImage());
        holder.tetView.setText(items.get(position).getMad());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mlistener !=null){
                    mlistener.onItemClick(holder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tetView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tetView = itemView.findViewById(R.id.mod);

            imageView = itemView.findViewById(R.id.res_image);
        }
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}

