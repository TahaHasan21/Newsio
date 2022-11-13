package com.example.newsio;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<InitilizationsMod> ModArrayList;

    public Adapter(Context context, ArrayList<InitilizationsMod> modArrayList) {
        this.context = context;
        this.ModArrayList = modArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(context,webView.class);
//
//                context.startActivity(intent);
                Intent intent = new Intent(context,DetailedNews.class);
                intent.putExtra("title",ModArrayList.get(holder.getAdapterPosition()).getTitle());
                intent.putExtra("content",ModArrayList.get(holder.getAdapterPosition()).getContent());
                intent.putExtra("url",ModArrayList.get(holder.getAdapterPosition()).getUrl());
                intent.putExtra("urltoimage",ModArrayList.get(holder.getAdapterPosition()).getUrlToImage());
                intent.putExtra("desc",ModArrayList.get(holder.getAdapterPosition()).getDescription());
                context.startActivity(intent);

            }
        });

        holder.headline.setText(ModArrayList.get(position).getTitle());
        holder.description.setText(ModArrayList.get(position).getDescription());
//        holder.author.setText(ModArrayList.get(position).getAuthor());
        Glide.with(context).load(ModArrayList.get(position).getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return ModArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        CardView cardView;
        TextView headline,description,author,time;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            headline = itemView.findViewById(R.id.mainheading);
            description = itemView.findViewById(R.id.description);
            author = itemView.findViewById(R.id.author);
            time = itemView.findViewById(R.id.time);
            imageView = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.cardView);


        }
    }
}
