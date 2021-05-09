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
import com.example.moviecatalogue.models.TvAiringToday;
import com.example.moviecatalogue.networks.Const;

public class TvAiringTodayAdapter extends RecyclerView.Adapter<TvAiringTodayAdapter.ViewHolder> {
    private List<TvAiringToday> tvAiringTodays;
    private OnItemClick onItemClick;

    public TvAiringTodayAdapter(List<TvAiringToday> tvAiringTodays, OnItemClick onItemClick) {
        this.tvAiringTodays = tvAiringTodays;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_movie, viewGroup, false);
        return new ViewHolder(view, onItemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(viewHolder.itemView.getContext())
                .load(Const.IMG_URL_200 + tvAiringTodays.get(i).getImgUrl())
                .into(viewHolder.ivPoster);
        viewHolder.tvTitle.setText(tvAiringTodays.get(i).getName());
        viewHolder.tvVoteAverage.setText(tvAiringTodays.get(i).getVoteAverage());
    }

    @Override
    public int getItemCount() {
        return tvAiringTodays.size();
    }

    public interface OnItemClick {
        void onClick(int pos);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        OnItemClick onItemClick;
        ImageView ivPoster;
        TextView tvTitle;
        TextView tvVoteAverage;

        ViewHolder(@NonNull View itemView, OnItemClick onItemClick) {
            super(itemView);
            itemView.setOnClickListener(this);
            ivPoster = itemView.findViewById(R.id.iv_poster);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvVoteAverage = itemView.findViewById(R.id.tv_vote_average);
            this.onItemClick = onItemClick;
        }

        @Override
        public void onClick(View view) {
            onItemClick.onClick(getAdapterPosition());
        }
    }
}
