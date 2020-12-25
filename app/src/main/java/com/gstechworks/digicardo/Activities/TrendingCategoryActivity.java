package com.gstechworks.digicardo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.databinding.DataBindingUtil;

import android.content.res.TypedArray;
import android.os.Bundle;

import com.gstechworks.digicardo.Adapters.TrendingCategoriesAdapter;
import com.gstechworks.digicardo.Models.TrendingModel;
import com.gstechworks.digicardo.R;
import com.gstechworks.digicardo.databinding.ActivityTrendingCategoryBinding;

import java.util.ArrayList;

public class TrendingCategoryActivity extends AppCompatActivity {
    ActivityTrendingCategoryBinding binding;
    ArrayList<TrendingModel>trendingModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_trending_category);
        //Trending Categories

        TypedArray images = getResources().obtainTypedArray(R.array.trendingimages);
        String[]names = getResources().getStringArray(R.array.trendingnames);
        for(int i =0; i<images.length(); i++)
        {
            TrendingModel trendingModel = new TrendingModel(images.getResourceId(i, 0), names[i]);
            trendingModels.add(trendingModel);
        }
        TrendingCategoriesAdapter adapter = new TrendingCategoriesAdapter(trendingModels, this);
        binding.AllTrendingCatRecyclerView.setAdapter(adapter);
        binding.AllTrendingCatRecyclerView.setNestedScrollingEnabled(false);
    }
}