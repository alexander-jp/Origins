package com.mundet.origins.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;
import com.mundet.origins.DetalleMovies;
import com.mundet.origins.Models.Home;
import com.mundet.origins.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapterHome extends RecyclerView.Adapter<RecyclerViewAdapterHome.MyViewHolder> {
    ArrayList<Home> array = new ArrayList<>();
    Context context;

    public RecyclerViewAdapterHome(ArrayList<Home> array, Context context) {
        this.array = array;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterHome.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_home, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterHome.MyViewHolder holder, int position) {
        holder.textView.setText(array.get(position).getMovie_name());
        Log.i("fragment", array.get(position).getMovie_url());
        Glide.with(context).load(array.get(position).getUrl_img()).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetalleMovies.class);
                ActivityOptionsCompat options = (ActivityOptionsCompat) ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context,
                        holder.imageView, ViewCompat.getTransitionName(holder.imageView));
                view.getContext().startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtNombre)
        TextView textView;
        @BindView(R.id.imgMovie)
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
