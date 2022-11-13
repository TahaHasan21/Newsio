package com.example.newsio;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentPageAdp extends FragmentPagerAdapter {


    int tabCount;
    public FragmentPageAdp(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFrag();
            case 1:
                return new SportsFrag();
            case 2:
                return new entertainmentfrag();
            case 3:
                return new techfrag();

            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return tabCount;
    }
}

