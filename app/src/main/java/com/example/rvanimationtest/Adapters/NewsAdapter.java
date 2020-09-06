package com.example.rvanimationtest.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rvanimationtest.Models.NewsItem;
import com.example.rvanimationtest.R;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> implements Filterable {

    private Context mContext;
    private List<NewsItem> mData;
    private List<NewsItem> mDataFiltered;
    private boolean isDark = false;

    public NewsAdapter(Context mContext, List<NewsItem> mData, boolean isDark) {
        this.mContext = mContext;
        this.mData = mData;
        this.isDark = isDark;

        // ВАЖНО
        // Отсортированый список принимает тот же список тех же элементов!!!
        this.mDataFiltered = mData;
    }

    public NewsAdapter(Context mContext, List<NewsItem> mData) {
        this.mContext = mContext;
        this.mData = mData;

        // ВАЖНО
        // Отсортированый список принимает тот же список тех же элементов!!!
        this.mDataFiltered = mData;
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

        newsViewHolder.tvTitle.setText(mDataFiltered.get(i).getTitle());
        newsViewHolder.tvDescription.setText(mDataFiltered.get(i).getContent());
        newsViewHolder.tvDate.setText(mDataFiltered.get(i).getDate());

        //newsViewHolder.userImg.setImageResource(mData.get(i).getUserPhoto());
        Glide.with(mContext).load(mDataFiltered.get(i).getUserPhoto()).into(newsViewHolder.userImg);
    }

    @Override
    public int getItemCount() {
        return mDataFiltered.size();
    }

    @Override
    public Filter getFilter() {


        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String Key = constraint.toString();
                if (Key.isEmpty()){
                    mData = mDataFiltered;
                } else {
                    List<NewsItem> lstNewsFiltered = new ArrayList<>();
                    for (NewsItem row : mData){
                        if (row.getTitle().toLowerCase().contains(Key.toLowerCase())){
                            lstNewsFiltered.add(row);
                        }
                    }

                    mDataFiltered = lstNewsFiltered;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mDataFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                mDataFiltered = (List<NewsItem>) results.values;
                notifyDataSetChanged();
            }
        };
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
