package com.example.mpproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    final List<Fragment> mFragmentList=new ArrayList<>();
    final List<String> mFragmenTitleList=new ArrayList<>();
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public void addFragement(Fragment fragment, String title){
        mFragmentList.add(fragment);
        mFragmenTitleList.add(title);
    }

    public CharSequence getPageTitle(int position){
        return mFragmenTitleList.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
