package com.gstechworks.digicardo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;

import com.gstechworks.digicardo.Adapters.OfferAdapter;
import com.gstechworks.digicardo.Adapters.SlideAdapter;
import com.gstechworks.digicardo.Models.OffersModel;
import com.gstechworks.digicardo.Models.SliderModel;
import com.gstechworks.digicardo.R;
import com.gstechworks.digicardo.databinding.ActivityOffersBinding;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class OffersActivity extends AppCompatActivity {
    ArrayList<SliderModel> sliderModels = new ArrayList<>();
    ActivityOffersBinding binding;
    ArrayList<OffersModel>offersModels = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_offers);

        TypedArray bannerimages = getResources().obtainTypedArray(R.array.bannerimage);
        for(int i =0; i<bannerimages.length(); i++){
            SliderModel sliderModel = new SliderModel(bannerimages.getResourceId(i,0));
            sliderModels.add(sliderModel);
        }
        SlideAdapter slideAdapter = new SlideAdapter(sliderModels, this);
        binding.imageSlider.setSliderAdapter(slideAdapter);
        binding.imageSlider.setIndicatorAnimation(IndicatorAnimations.WORM);
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        binding.imageSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        binding.imageSlider.setIndicatorSelectedColor(Color.BLUE);
        binding.imageSlider.setIndicatorUnselectedColor(Color.BLACK);
        binding.imageSlider.setScrollTimeInSec(2);
        binding.imageSlider.startAutoCycle();

        TypedArray offerimages = getResources().obtainTypedArray(R.array.offersimages);
        for(int i =0; i<offerimages.length(); i++){
            OffersModel offersModel = new OffersModel(offerimages.getResourceId(i,0));
            offersModels.add(offersModel);
        }
        OfferAdapter adapter = new OfferAdapter(offersModels, this);
        binding.OffersRecyclerView.setAdapter(adapter);

    }
}