package com.nerdware.automotiveengineering.Module1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.nerdware.automotiveengineering.Module_1;
import com.nerdware.automotiveengineering.PDF;
import com.nerdware.automotiveengineering.R;
import java.util.ArrayList;

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.Module_ViewHolder>{

    ArrayList<module_item> module_items;

    Context context;
    Activity activity;

    int Counter = 0;



    public ModuleAdapter(ArrayList<module_item> module_items, Context context,ItemClickListener clickListener) {
        this.module_items = module_items;
        this.context = context;
    }

    public ModuleAdapter(Module_1 context) {
    }


    @NonNull
    @Override
    public ModuleAdapter.Module_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new Module_ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.model_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ModuleAdapter.Module_ViewHolder holder, int position) {

        holder.imageView.setImageResource(module_items.get(position).getImage());
        holder.tryy.setText(module_items.get(position).getNaa());
        holder.poo.setText(module_items.get(position).getPubb());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();

                String fileName = "";

                switch (position) {
                    case 0:
                        fileName = "mao.pdf";
                        break;
                    case 1:
                        fileName = "as.pdf";
                        break;
                    case 2:
                        fileName = "td.pdf";
                        break;
                    case 3 :
                        fileName = "eep.pdf";
                        break;
                    case 4 :
                        fileName = "ee.pdf";
                        break;
                    case 5 :
                        fileName = "ict.pdf";
                        break;
                    case 6 :
                        fileName = "vehicle tech.pdf";
                        break;
                    case 7 :
                        fileName = "body work.pdf";
                        break;
                    case 8 :
                        fileName = "work tech.pdf";
                        break;

                }


                Intent intent = new Intent(v.getContext(), PDF.class);
                intent.putExtra("FILE_NAME", fileName);
                v.getContext().startActivity(intent);
            }


        });

    }



    @Override
    public int getItemCount() {
        return module_items.size();
    }

    public class Module_ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tryy;
        TextView poo;


        public Module_ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.m1);
            tryy = itemView.findViewById(R.id.text1);
            poo = itemView.findViewById(R.id.pub1);
        }
    }
    public interface ItemClickListener{
        void OnClick(int position, Object o);
    }
}
