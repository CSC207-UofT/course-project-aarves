package com.aarves.bluepages;

import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

public class MainMenuAdapter extends FragmentStateAdapter {

    private final ViewPager2 viewPager;

    public MainMenuAdapter(FragmentActivity fa, ViewPager2 view) {
        super(fa);
        this.viewPager = view;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new MainMenuFragment();
        } else {

            Handler handler = new Handler();
            handler.postDelayed(() -> viewPager.setUserInputEnabled(false), 2000);

            return new MapFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
