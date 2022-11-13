package com.example.newsio;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import com.example.newsio.FragmentPageAdp;
import com.example.newsio.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {
    FragmentPageAdp adp;
    TabLayout tabLayout;
    ViewPager vp;
    TabItem mhome,msports,ment,mtech;
    Toolbar t1;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        t1=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(t1);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        pb = (ProgressBar) findViewById(R.id.progbar);

        mhome = (TabItem) findViewById(R.id.Homefr);
        msports = (TabItem) findViewById(R.id.sportsfr);
        ment = (TabItem) findViewById(R.id.enfr);
        mtech = (TabItem) findViewById(R.id.techfr);

        vp = (ViewPager) findViewById(R.id.fragmentcontainer);
        adp = new FragmentPageAdp(getSupportFragmentManager(),4);

        vp.setAdapter(adp);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pb.setVisibility(View.VISIBLE);
                vp.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3){
                    adp.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



    }

}
