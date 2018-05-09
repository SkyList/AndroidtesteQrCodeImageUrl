package com.skylist.android_teste;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoProvider;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<ModelRecycleView> dataset;
    private Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nomeTV, materiaTV, dataTV;
        public ImageView image;
        public MyViewHolder( View view ){
            super(view);

            nomeTV = view.findViewById(R.id.id_nome);
            materiaTV = view.findViewById(R.id.id_materia);
            dataTV = view.findViewById(R.id.id_data);
            image = view.findViewById(R.id.imageView4);

        }
    }

    MyAdapter( List<ModelRecycleView> dataset ){
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate( R.layout.layout_my_recycleview, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        ModelRecycleView item = dataset.get(position);
        holder.nomeTV.setText(item.getNome());
        holder.materiaTV.setText(item.getMateria());
        holder.dataTV.setText(item.getData());
        Picasso.get().load( item.getUrlImage() ).resize(230, 230 ).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
