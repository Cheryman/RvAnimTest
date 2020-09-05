package com.example.rvanimationtest.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rvanimationtest.Adapters.NewsAdapter;
import com.example.rvanimationtest.Models.NewsItem;
import com.example.rvanimationtest.R;

import java.util.ArrayList;
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

        iniList();

        newsAdapter = new NewsAdapter(this, newsList);
        NewsRecyclerView.setAdapter(newsAdapter);
        NewsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void iniList() {
        NewsRecyclerView = findViewById(R.id.news_rv);
        newsList = new ArrayList<>();
        newsList.add(new NewsItem("Білоруські айтішники тікають до України",
                "У зв'язку з жорстоким розгоном протестів у Білорусі IT-компанії вивозять, а деякі планують вивезти частину співробітників. Україну називають однією з країн, куди переїздять білоруські айтішники.",
                "26 серпень 2020", R.drawable.boy));
        newsList.add(new NewsItem("Країни, які вимикають інтернет. Як і навіщо вони це роблять",
                "Деякі держави вдаються до особливого виду репресій – позбавляють громадян доступу до інтернету.",
                "11 серпень 2020", R.drawable.businessman));
        newsList.add(new NewsItem("Філарет захворів на Covid-19. Він у лікарні",
                "Почесний патріарх Православної церкви України Філарет підхопив коронавірус.",
                "4 вересень 2020", R.drawable.boy2));
        newsList.add(new NewsItem("Коронавірус в Україні. Інтерактивна мапа",
                "В якій області найбільше інфікованих коронавірусом? Скільки одужало? А скільки померло? Все це - на нашій інтерактивній мапі.",
                "4 вересень 2020", R.drawable.girl));
        newsList.add(new NewsItem("Російська радіостанція-привид. Кому вона передає свої моторошні сигнали",
                "Радіостанція МДЖБ, або \"Дзижчалка\", веде свої дивні передачі на коротких хвилях з 1982 року. Кому призначене це дзижчання і зачитування в ефірі безглуздих цифр і слів?",
                "9 серпень 2020", R.drawable.girl2));
        newsList.add(new NewsItem("Сигнал від злиття чорних дір пролетів 7 млрд років і \"сколихнув\" Землю",
                "Уявіть, як енергія восьми Сонць в один момент вивільняється у простір. Відголоски цього йшли до Землі 7 млрд років, але їх змогли зафіксувати вчені.",
                "3 вересень 2020",R.drawable.boy3));
        newsList.add(new NewsItem("Країни, які вимикають інтернет. Як і навіщо вони це роблять",
                "Деякі держави вдаються до особливого виду репресій – позбавляють громадян доступу до інтернету.",
                "11 серпень 2020", R.drawable.businessman));
        newsList.add(new NewsItem("Філарет захворів на Covid-19. Він у лікарні",
                "Почесний патріарх Православної церкви України Філарет підхопив коронавірус.",
                "4 вересень 2020", R.drawable.boy2));
        newsList.add(new NewsItem("Коронавірус в Україні. Інтерактивна мапа",
                "В якій області найбільше інфікованих коронавірусом? Скільки одужало? А скільки померло? Все це - на нашій інтерактивній мапі.",
                "4 вересень 2020", R.drawable.girl));
        newsList.add(new NewsItem("Білоруські айтішники тікають до України",
                "У зв'язку з жорстоким розгоном протестів у Білорусі IT-компанії вивозять, а деякі планують вивезти частину співробітників. Україну називають однією з країн, куди переїздять білоруські айтішники.",
                "26 серпень 2020", R.drawable.boy));
        newsList.add(new NewsItem("Країни, які вимикають інтернет. Як і навіщо вони це роблять",
                "Деякі держави вдаються до особливого виду репресій – позбавляють громадян доступу до інтернету.",
                "11 серпень 2020", R.drawable.businessman));
        newsList.add(new NewsItem("Філарет захворів на Covid-19. Він у лікарні",
                "Почесний патріарх Православної церкви України Філарет підхопив коронавірус.",
                "4 вересень 2020", R.drawable.boy2));
        newsList.add(new NewsItem("Коронавірус в Україні. Інтерактивна мапа",
                "В якій області найбільше інфікованих коронавірусом? Скільки одужало? А скільки померло? Все це - на нашій інтерактивній мапі.",
                "4 вересень 2020", R.drawable.girl));
        newsList.add(new NewsItem("Російська радіостанція-привид. Кому вона передає свої моторошні сигнали",
                "Радіостанція МДЖБ, або \"Дзижчалка\", веде свої дивні передачі на коротких хвилях з 1982 року. Кому призначене це дзижчання і зачитування в ефірі безглуздих цифр і слів?",
                "9 серпень 2020", R.drawable.girl2));
    }
}