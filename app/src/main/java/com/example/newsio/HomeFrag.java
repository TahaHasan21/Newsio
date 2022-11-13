package com.example.newsio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFrag extends Fragment {

    String api ="d3cf60554e274d328075057c56ba5e38";
    Adapter adp;
    ArrayList<InitilizationsMod> modArrayList;
    String country = "in";
    private RecyclerView homerecview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.homefrag,null);
        homerecview = v.findViewById(R.id.homerecycler);
        modArrayList = new ArrayList<>();
        homerecview.setLayoutManager(new LinearLayoutManager(getContext()));
        adp = new Adapter(getContext(),modArrayList);
        homerecview.setAdapter(adp);
        Call<NewsMain> news = ApiUt.getApiInterface().getNews(country, 100, api);
        news.enqueue(new Callback<NewsMain>() {
            @Override
            public void onResponse(Call<NewsMain> call, Response<NewsMain> response) {
                modArrayList.addAll(response.body().getArticles());
                adp.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NewsMain> call, Throwable t) {

            }
        });
        return v;
    }


}
