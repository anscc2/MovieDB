package com.example.moviecatalogue.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import com.example.moviecatalogue.R;
import com.example.moviecatalogue.models.Upcoming;
import com.example.moviecatalogue.networks.Const;

public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingAdapter.ViewHolder> {
    private List<Upcoming> upcomings;

    public UpcomingAdapter(List<Upcoming> upcomings) {
        this.upcomings = upcomings;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_movie, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(viewHolder.itemView.getContext())
                .load(Const.IMG_URL_200 + upcomings.get(i).getImgUrl())
                .into(viewHolder.ivPoster);
        viewHolder.tvTitle.setText(upcomings.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return upcomings.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivPoster;
        TextView tvTitle;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPoster = itemView.findViewById(R.id.iv_poster);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
