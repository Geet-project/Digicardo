package com.gstechworks.digicardo.Fragments;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.gstechworks.digicardo.Activities.TrendingCategoryActivity;
import com.gstechworks.digicardo.Adapters.DigiZoneAdapter;
import com.gstechworks.digicardo.Adapters.SlideAdapter;
import com.gstechworks.digicardo.Adapters.TrendingCategoriesAdapter;
import com.gstechworks.digicardo.Adapters.ViewPagerAdapter;
import com.gstechworks.digicardo.Models.DigiModels;
import com.gstechworks.digicardo.Models.SliderModel;
import com.gstechworks.digicardo.Models.TrendingModel;
import com.gstechworks.digicardo.R;
import com.gstechworks.digicardo.SharedPreferences.SessionConfig;
import com.gstechworks.digicardo.databinding.FragmentHomeBinding;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    ArrayList<SliderModel>sliderModels = new ArrayList<>();
    ArrayList<TrendingModel>trendingModels = new ArrayList<>();
    ArrayList<DigiModels>digiModels = new ArrayList<>();
    SessionConfig sessionConfig;
    boolean LoginState;
    String userMobile;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        sessionConfig = new SessionConfig(getContext());
        TypedArray bannerimages = getResources().obtainTypedArray(R.array.bannerimage);
        for(int i =0; i<bannerimages.length(); i++){
            SliderModel sliderModel = new SliderModel(bannerimages.getResourceId(i,0));
            sliderModels.add(sliderModel);
        }
        SlideAdapter slideAdapter = new SlideAdapter(sliderModels, getContext());
        binding.imageSlider.setSliderAdapter(slideAdapter);
        binding.imageSlider.setIndicatorAnimation(IndicatorAnimations.WORM);
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        binding.imageSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        binding.imageSlider.setIndicatorSelectedColor(Color.BLUE);
        binding.imageSlider.setIndicatorUnselectedColor(Color.BLACK);
        binding.imageSlider.setScrollTimeInSec(2);
        binding.imageSlider.startAutoCycle();


        //Trending Categories

        TypedArray images = getResources().obtainTypedArray(R.array.trendingimages);
        String[]names = getResources().getStringArray(R.array.trendingnames);
        for(int i =0; i<images.length(); i++)
        {
            TrendingModel trendingModel = new TrendingModel(images.getResourceId(i, 0), names[i]);
            trendingModels.add(trendingModel);
        }
        TrendingCategoriesAdapter adapter = new TrendingCategoriesAdapter(trendingModels, getContext());
        binding.TrendingCategoryRecyclerView.setAdapter(adapter);
        binding.TrendingCategoryRecyclerView.setNestedScrollingEnabled(false);

        //trending business
        binding.TrendingBusinessRecyclerView.setAdapter(adapter);
        binding.TrendingBusinessRecyclerView.setNestedScrollingEnabled(false);


        //DigiCardo My Zone

        String[] digiNames = getResources().getStringArray(R.array.DigiMyZoneText);
        TypedArray digiImages = getResources().obtainTypedArray(R.array.DigiMyZoneImg);
        for(int i =0; i<digiImages.length(); i++){
            DigiModels digiModel = new DigiModels(digiImages.getResourceId(i,0), digiNames[i]);
            digiModels.add(digiModel);
        }
        DigiZoneAdapter adapter1 = new DigiZoneAdapter(digiModels, getContext());
        binding.DigicardoMyzoneRecyclerView.setAdapter(adapter1);
        binding.DigicardoMyzoneRecyclerView.setNestedScrollingEnabled(false);

        //DigiCardo Bonus Zone
        String[] digiBonusNames = getResources().getStringArray(R.array.DigiBonusText);
        TypedArray digiBonusImages = getResources().obtainTypedArray(R.array.DigiBonusImg);
        for(int i =0; i<digiBonusImages.length(); i++){
            DigiModels digiModel = new DigiModels(digiBonusImages.getResourceId(i,0), digiBonusNames[i]);
            digiModels.add(digiModel);
        }
        DigiZoneAdapter adapter2 = new DigiZoneAdapter(digiModels, getContext());
        binding.DigicardoBonusZoneRecyclerView.setAdapter(adapter1);
        binding.DigicardoBonusZoneRecyclerView.setNestedScrollingEnabled(false);

        //Slider 2

        binding.imageSlider2.setSliderAdapter(slideAdapter);
        binding.imageSlider2.setIndicatorAnimation(IndicatorAnimations.WORM);
        binding.imageSlider2.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        binding.imageSlider2.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        binding.imageSlider2.setIndicatorSelectedColor(Color.BLUE);
        binding.imageSlider2.setIndicatorUnselectedColor(Color.BLACK);
        binding.imageSlider2.setScrollTimeInSec(2);
        binding.imageSlider2.startAutoCycle();


        binding.trendingviewall.setOnClickListener(view -> {
            Intent i = new Intent(getContext(), TrendingCategoryActivity.class);
            startActivity(i);
        });


        //checking user login

        return binding.getRoot();
    }


}