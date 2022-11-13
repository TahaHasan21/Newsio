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


public class SportsFrag extends Fragment {

    String api ="d3cf60554e274d328075057c56ba5e38";
    Adapter adp;
    ArrayList<InitilizationsMod> modArrayList;
    String country = "in";
    private RecyclerView sportsrecview;
    private String Category = "sports";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sportsfrag,null);
        sportsrecview = v.findViewById(R.id.sportsrecycler);
        modArrayList = new ArrayList<>();
        sportsrecview.setLayoutManager(new LinearLayoutManager(getContext()));
        adp = new Adapter(getContext(),modArrayList);
        sportsrecview.setAdapter(adp);
        displayNews();
        return v;
    }

    private void displayNews(){

        ApiUt.getApiInterface().getCategoryNews(country,Category,100,api).enqueue(new Callback<NewsMain>() {
            @Override
            public void onResponse(Call<NewsMain> call, Response<NewsMain> response) {
                modArrayList.addAll(response.body().getArticles());
                adp.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NewsMain> call, Throwable t) {

            }
        });
    }

}

