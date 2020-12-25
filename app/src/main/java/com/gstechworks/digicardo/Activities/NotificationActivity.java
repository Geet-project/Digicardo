package com.gstechworks.digicardo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabLayout;
import com.gstechworks.digicardo.Adapters.ViewPagerAdapter;
import com.gstechworks.digicardo.Fragments.AdminNotiFragment;
import com.gstechworks.digicardo.Fragments.EnquiryFragment;
import com.gstechworks.digicardo.R;
import com.gstechworks.digicardo.databinding.ActivityNotificationBinding;

public class NotificationActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    View mIndicator;
    int indicatorWidth;
    ActivityNotificationBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_notification);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewPager);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //Determine indicator width at runtime
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
//                indicatorWidth = tabLayout.getWidth() / tabLayout.getTabCount();
//
//                //Assign new width
//                FrameLayout.LayoutParams indicatorParams = (FrameLayout.LayoutParams) mIndicator.getLayoutParams();
//                indicatorParams.width = indicatorWidth;
//                mIndicator.setLayoutParams(indicatorParams);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            //To move the indicator as the user scroll, we will need the scroll offset values
            //positionOffset is a value from [0..1] which represents how far the page has been scrolled
            //see https://developer.android.com/reference/android/support/v4/view/ViewPager.OnPageChangeListener
            @Override
            public void onPageScrolled(int i, float positionOffset, int positionOffsetPx) {
//                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams)mIndicator.getLayoutParams();
//
//                //Multiply positionOffset with indicatorWidth to get translation
//                float translationOffset =  (positionOffset+i) * indicatorWidth ;
//                params.leftMargin = (int) translationOffset;
//                mIndicator.setLayoutParams(params);
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        binding.BackArrow.setOnClickListener(view -> {
            onBackPressed();
            finish();
        });
    }

        public void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new EnquiryFragment(), "Enquiry");
        viewPagerAdapter.addFragment(new AdminNotiFragment(), "Admin Notification");
        viewPager.setAdapter(viewPagerAdapter);


    }
}