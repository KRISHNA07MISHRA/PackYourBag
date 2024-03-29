package com.example.packyourbag.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.packyourbag.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder>{
    List<String> titles;
    List<Integer> images;
    LayoutInflater inflater;
    Activity activity;


    // yaha data ko recyclerview me pass karne ke liya setup kiya jata ha
    public Adapter(Context context, List<Integer> images, List<String>titles, Activity activity) {
        this.images = images;
        this.titles = titles;
        this.activity = activity;
        this.inflater = LayoutInflater.from(context);


    }

    @NonNull
    @Override    //yaha ek new view holder banaya gaya ha
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.main_item,parent,false);
        return new myViewHolder(view);
    }

    @Override //
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.title.setText(titles.get(position));
        holder.img.setImageResource(images.get(position));
        holder.linearLayout.setAlpha(0.8f);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity,"CLICKED ON CARD", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }


    // yaha recycler view ke ek holder ko setup kiya gaya ha
    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView img;
        LinearLayout linearLayout;

        public myViewHolder(@NonNull View itemView) { // here we declear all my item which using in to show recycler view
            super(itemView);

            title = itemView.findViewById(R.id.title);
            img = itemView.findViewById(R.id.img);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
