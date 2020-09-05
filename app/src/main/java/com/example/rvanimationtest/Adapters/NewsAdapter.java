package com.example.rvanimationtest.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rvanimationtest.Models.NewsItem;
import com.example.rvanimationtest.R;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private Context mContext;
    private List<NewsItem> mData;
    private boolean isDark = false;

    public NewsAdapter(Context mContext, List<NewsItem> mData, boolean isDark) {
        this.mContext = mContext;
        this.mData = mData;
        this.isDark = isDark;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_news, viewGroup, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int i) {

        newsViewHolder.userImg.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_transition_anim));
        newsViewHolder.container.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_scale_animation));

        newsViewHolder.tvTitle.setText(mData.get(i).getTitle());
        newsViewHolder.tvDescription.setText(mData.get(i).getContent());
        newsViewHolder.tvDate.setText(mData.get(i).getDate());

        //newsViewHolder.userImg.setImageResource(mData.get(i).getUserPhoto());
        Glide.with(mContext).load(mData.get(i).getUserPhoto()).into(newsViewHolder.userImg);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle, tvDescription, tvDate;
        private ImageView userImg;
        private RelativeLayout container;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvDate = itemView.findViewById(R.id.tvDate);
            container = itemView.findViewById(R.id.container);

            userImg = itemView.findViewById(R.id.imgUser);

            if (isDark) {
                setDarkTheme();
            }
        }

        private void setDarkTheme() {
            container.setBackgroundResource(R.drawable.card_bg_dark);
        }
    }

}
