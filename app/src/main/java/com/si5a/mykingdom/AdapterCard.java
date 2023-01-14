package com.si5a.mykingdom;

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

public class AdapterCard extends  RecyclerView.Adapter<AdapterCard.ClassViewHolder>{
    private ArrayList<ModelKingdom> dataKingdom;
    private Context ctx;

    public AdapterCard(ArrayList<ModelKingdom> dataKingdom, Context ctx) {
        this.dataKingdom = dataKingdom;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater.from(ctx).inflate(R.layout.item_card, parent, false);
        return new ClassViewHolder(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
        ModelKingdom Kingdom = dataKingdom.get(position);
        holder.tvNama.setText(Kingdom.getNama());
        holder.tvTentang.setText(Kingdom.getTentang());
        Glide
                .with(ctx)
                .load(Kingdom.getFoto())
                .centerCrop()
                .into(holder.ivFoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String xNama, xTentang, xFoto;


                xNama = Kingdom.getNama();
                xTentang = Kingdom.getTentang();
                xFoto = Kingdom.getFoto();

                Intent kirim = new Intent(ctx, DetailActivity.class);
                kirim.putExtra("xNama", xNama);
                kirim.putExtra("xTentang", xTentang);
                kirim.putExtra("xFoto", xFoto);
                ctx.startActivity(kirim);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataKingdom.size();
    }

    public class ClassViewHolder extends RecyclerView.ViewHolder{
        TextView tvNama, tvTentang;
        ImageView ivFoto;

        public ClassViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama =itemView.findViewById(R.id.tv_nama);
            tvTentang = itemView.findViewById(R.id.tv_tentang);
            ivFoto = itemView.findViewById(R.id.iv_foto);

        }
    }
}