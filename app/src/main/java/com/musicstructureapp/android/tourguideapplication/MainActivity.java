package com.musicstructureapp.android.tourguideapplication;

import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.musicstructureapp.android.tourguideapplication.Adapters.FragmentsAdapter;
import com.musicstructureapp.android.tourguideapplication.Fragments.AttractionsFrag;
import com.musicstructureapp.android.tourguideapplication.Fragments.MonumentsFrag;
import com.musicstructureapp.android.tourguideapplication.Fragments.PlacesFrag;
import com.musicstructureapp.android.tourguideapplication.Fragments.RestaurantFrag;

public class MainActivity extends AppCompatActivity {

    FragmentsAdapter mFragmentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PagerTabStrip tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setTabIndicatorColor(getResources().getColor(R.color.colorAccent));

        ViewPager myViewpager = findViewById(R.id.viewPager);
        setupViewPager(myViewpager);
    }

    private void setupViewPager(ViewPager viewPager){
        mFragmentsAdapter = new FragmentsAdapter(getSupportFragmentManager());

        mFragmentsAdapter.addFragment(new AttractionsFrag(), "Attractions");
        mFragmentsAdapter.addFragment(new MonumentsFrag(), "Monuments");
        mFragmentsAdapter.addFragment(new PlacesFrag(), "Places");
        mFragmentsAdapter.addFragment(new RestaurantFrag(), "Restaurants");
        viewPager.setAdapter(mFragmentsAdapter);
    }
}
