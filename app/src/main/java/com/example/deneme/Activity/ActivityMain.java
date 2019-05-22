package com.example.deneme.Activity;

import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.deneme.Alagan.Alagan;
import com.example.deneme.Fragment.FragmentOgren;
import com.example.deneme.Fragment.FragmentProfil;
import com.example.deneme.Fragment.FragmentTest;
import com.example.deneme.R;

public class ActivityMain extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    ConstraintLayout myLayout;
    AnimationDrawable animationDrawable;
    public static ActivityMain Instance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Instance = this;
        new Alagan(getApplication());

        //ArkaPlan Animasyonu
        myLayout = (ConstraintLayout) findViewById(R.id.myLayout);

        animationDrawable = (AnimationDrawable) myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();


        // Bottom Navigasyonu
        BottomNavigationView navigation = findViewById(R.id.ActivityMainBottomNavigation);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new FragmentOgren());


    }



    public boolean loadFragment(Fragment fragment){
        if(fragment != null){

            getSupportFragmentManager().beginTransaction().replace(R.id.ActivityMainTestFrameLayout,fragment).commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = null ;

        switch (menuItem.getItemId()){
            case R.id.BottomNavigationOgren:
                fragment = new FragmentOgren();
                break;

            case R.id.BottomNavigationTestOl:
                fragment = new FragmentTest();
                break;

            case R.id.BottomNavigationProfile:
                fragment = new FragmentProfil();
                break;
        }
        return loadFragment(fragment);
    }
}
