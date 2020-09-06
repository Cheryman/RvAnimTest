package com.example.rvanimationtest.UI;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.example.rvanimationtest.Adapters.NewsAdapter;
import com.example.rvanimationtest.R;
import com.example.rvanimationtest.utils.DataSource;

public class MainActivity extends AppCompatActivity {

    private RecyclerView NewsRecyclerView;
    private NewsAdapter newsAdapter;
    private FloatingActionButton fabSwitcher;
    private boolean isDark = false;
    private ConstraintLayout rootLayout;
    private EditText searchInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        iniViews();

        // грузим сохраенный boolean
        isDark = getThemeStatePref();
        if (isDark){
            // DarkTheme is on
            searchInput.setBackgroundResource(R.drawable.search_input_style_dark);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.black));
        } else {
            // LightTheme is on
            searchInput.setBackgroundResource(R.drawable.search_input_style);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.white));
        }

        iniNewsList();

        fabSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDark = !isDark;
                if (isDark) {
                    rootLayout.setBackgroundColor(getResources().getColor(R.color.black));
                    searchInput.setBackgroundResource(R.drawable.search_input_style_dark);
                } else {
                    rootLayout.setBackgroundColor(getResources().getColor(R.color.white));
                    searchInput.setBackgroundResource(R.drawable.search_input_style);
                }

                newsAdapter = new NewsAdapter(getApplicationContext(), DataSource.getNewsItems(), isDark);
                NewsRecyclerView.setAdapter(newsAdapter);
                saveThemePref(isDark);
            }
        });

        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                newsAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    // Сохраняем состояние
    private void saveThemePref(boolean isDark) {

        SharedPreferences preferences = getApplicationContext().getSharedPreferences("darkPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isDark", isDark);
        editor.apply();
    }

    // Получаем состояние по имени darkPref
    private boolean getThemeStatePref() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("darkPref", MODE_PRIVATE);
        return pref.getBoolean("isDark", false);
    }

    private void iniViews() {
        NewsRecyclerView = findViewById(R.id.news_rv);
        fabSwitcher = findViewById(R.id.fab_theme_switcher);
        rootLayout = findViewById(R.id.root_layout);
        searchInput = findViewById(R.id.search_input);
    }

    private void iniNewsList() {
        newsAdapter = new NewsAdapter(this, DataSource.getNewsItems(), isDark);
        NewsRecyclerView.setAdapter(newsAdapter);
        NewsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}