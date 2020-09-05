package com.example.rvanimationtest.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rvanimationtest.Adapters.NewsAdapter;
import com.example.rvanimationtest.Models.NewsItem;
import com.example.rvanimationtest.R;
import com.example.rvanimationtest.utils.DataSource;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView NewsRecyclerView;
    private NewsAdapter newsAdapter;
    List<NewsItem> newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        iniViews();

        iniNewsList();

    }

    private void iniViews() {
        NewsRecyclerView = findViewById(R.id.news_rv);
    }

    private void iniNewsList() {
        newsAdapter = new NewsAdapter(this, DataSource.getNewsItems());
        NewsRecyclerView.setAdapter(newsAdapter);
        NewsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}