package com.example.mpproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MaindashboardActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private int[] iconList={R.drawable.ic_person,R.drawable.ic_home,R.drawable.ic_setting,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maindashboard_layout);
        findviews();
        initToolbar();

    }

    private void setUpWithViewPager(){
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragement(new HomeFragment(),"Home");
        adapter.addFragement(new ProfileFragment(),"Profile");
        adapter.addFragement(new SettingFragment(),"Setting");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void findviews(){
        tabLayout= findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        setUpWithViewPager();
        tabLayout.getTabAt(0).setIcon(iconList[0]);
        tabLayout.getTabAt(1).setIcon(iconList[1]);
        tabLayout.getTabAt(2).setIcon(iconList[2]);
    }
    private void initToolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Dashboard");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}