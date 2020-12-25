package com.gstechworks.digicardo.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.gstechworks.digicardo.Adapters.ViewPagerAdapter;
import com.gstechworks.digicardo.Fragments.HomeFragment;
import com.gstechworks.digicardo.Fragments.SearchFragment;
import com.gstechworks.digicardo.Fragments.SignInFragment;
import com.gstechworks.digicardo.Fragments.SignUpFragment;
import com.gstechworks.digicardo.R;
import com.gstechworks.digicardo.SharedPreferences.SessionConfig;
import com.gstechworks.digicardo.databinding.ActivityHomeBinding;

import java.util.function.Function;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ActivityHomeBinding binding;
    SessionConfig sessionConfig;
    boolean LoginState;
    String userMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        sessionConfig = new SessionConfig(this);

        setFragment(new HomeFragment());
        binding.btmNav.show(1, true);

        binding.btmNav.add(new MeowBottomNavigation.Model(1, R.drawable.homeicon));
        binding.btmNav.add(new MeowBottomNavigation.Model(2, R.drawable.usericon));
        binding.btmNav.add(new MeowBottomNavigation.Model(3, R.drawable.searchicon));
        binding.btmNav.add(new MeowBottomNavigation.Model(4, R.drawable.hamburger_icon));

        binding.drawerView.setNavigationItemSelectedListener(this);
        View headerview = binding.drawerView.getHeaderView(0);
        ImageView closebtn = headerview.findViewById(R.id.closedrawer);
        closebtn.setOnClickListener(view -> {
            if(binding.gravityLayout.isDrawerOpen(Gravity.RIGHT)){
                binding.gravityLayout.closeDrawer(Gravity.RIGHT);
                binding.btmNav.show(1, true);

            }
        });


        binding.btmNav.setOnClickMenuListener(new MeowBottomNavigation.ClickListener(){

            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                switch (item.getId()){
                    case 1:
                        setFragment(new HomeFragment());
                        break;
                    case 3:
                        setFragment(new SearchFragment());
                        break;

                }
            }
        });

        binding.btmNav.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                switch (item.getId()){
                    case 1:
                        setFragment(new HomeFragment());
                        break;
                    case 4:
                        binding.gravityLayout.openDrawer(Gravity.RIGHT);
                        break;

                }
            }
        });

        binding.btmNav.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                switch (item.getId()){
                    case 1:
                        setFragment(new HomeFragment());
                        break;
                    case 4:
                        binding.gravityLayout.openDrawer(Gravity.RIGHT);
                        break;

                }
            }
        });

        binding.notiIcon.setOnClickListener(view -> {
            Intent i = new Intent(HomeActivity.this, NotificationActivity.class);
            startActivity(i);
        });


    }
    public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.commit();

    }

    public void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new SignInFragment(), "Sign In");
        viewPagerAdapter.addFragment(new SignUpFragment(), "Sign Up");
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.help_nav:
                Intent i = new Intent(HomeActivity.this, HelpActivity.class);
                startActivity(i);
                break;
            case R.id.categories_nav:
                Intent in = new Intent(HomeActivity.this, TrendingCategoryActivity.class );
                startActivity(in);
                break;

        }
        return false;
    }
}