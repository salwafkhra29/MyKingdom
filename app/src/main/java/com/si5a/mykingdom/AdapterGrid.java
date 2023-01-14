package com.si5a.mykingdom;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterGrid extends  RecyclerView.Adapter<AdapterGrid.ClassViewHolder>{
    private ArrayList<ModelKingdom> dataKingdom;
    private Context ctx;

    public AdapterGrid(ArrayList<ModelKingdom> dataPahlawan, Context ctx) {
        this.dataKingdom = dataPahlawan;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater.from(ctx).inflate(R.layout.item_grid, parent, false);
        return new ClassViewHolder(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
        ModelKingdom Kingdom = dataKingdom.get(position);
        Glide
                .with(ctx)
                .load(Kingdom.getFoto())
                .into(holder.ivGrid);

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

        ImageView ivGrid;

        public ClassViewHolder(@NonNull View itemView) {
            super(itemView);
            ivGrid = itemView.findViewById(R.id.iv_grid);

        }
    }
}
