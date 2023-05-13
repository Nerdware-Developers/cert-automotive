package com.nerdware.automotiveengineering.paper_i;

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

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.nerdware.automotiveengineering.PDF;
import com.nerdware.automotiveengineering.R;
import com.nerdware.automotiveengineering.paper_i_items;
import com.nerdware.automotiveengineering.paperads;
import java.util.ArrayList;

public class PaperAdapter extends RecyclerView.Adapter<PaperAdapter.PaperViewHolder>{

    ArrayList<paper_i_items> paperIItems;
    Context context;
    int Counter = 0;

    Activity activity;
    private  ItemClickListener clickListener;

    public PaperAdapter(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public PaperAdapter(ArrayList<paper_i_items> paperIItems, Context context) {
        this.paperIItems = paperIItems;
        this.context = context;
    }

    @NonNull
    @Override
    public PaperAdapter.PaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PaperViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.paper_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PaperAdapter.PaperViewHolder holder, int position) {
        holder.ttx.setText(paperIItems.get(position).getPp2());
        holder.imageView.setImageResource(paperIItems.get(position).getImg());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Counter++;
                if (Counter == 3) {
                    if (paperads.minterstitialAd != null) {
                        paperads.minterstitialAd.show(activity);
                        paperads.minterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                paperads.minterstitialAd = null;
                                paperads.loadads(activity);
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                super.onAdFailedToShowFullScreenContent(adError);
                                paperads.minterstitialAd = null;
                                paperads.loadads(activity);
                            }
                        });
                    }
                    Counter = 0;
                }
                int position = holder.getAdapterPosition();
                String fileName = "";

                switch (position) {
                    case 0:
                        fileName = "math1.pdf";
                        break;
                    case 1:
                        fileName = "as_eep.pdf";
                        break;
                    case 2:
                        fileName = "motor.pdf";
                        break;
                    case 3 :
                        fileName = "td1.pdf";
                        break;
                    case 4 :
                        fileName = "vehicle.pdf";
                        break;
                    case 5 :
                        fileName = "ict_ee.pdf";
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
        return paperIItems.size();
    }

    public class PaperViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView ;
        TextView ttx;

        public PaperViewHolder(@NonNull View itemView) {
            super(itemView);
            ttx = itemView.findViewById(R.id.namme);
            imageView = itemView.findViewById(R.id.paper_img);

        }
    }
    public interface ItemClickListener{
        void OnClick(int position, Object o);
    }
}
