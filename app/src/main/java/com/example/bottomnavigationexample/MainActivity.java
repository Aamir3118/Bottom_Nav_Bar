package com.example.bottomnavigationexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnView;
    FrameLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnView=findViewById(R.id.bnView);
        container=findViewById(R.id.conatiner);

        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int selected_id=item.getItemId();
                    if(selected_id == R.id.home)
                        loadFragment(new HomeFragment(),false);
                    else if(selected_id == R.id.search)
                        loadFragment(new SearchFragment(),false);
                    else if(selected_id == R.id.about_us)
                        loadFragment(new AboutUsFragment(),false);
                    else
                        loadFragment(new SettingsFragment(),true);


                return true;
            }
        });
        bnView.setSelectedItemId(R.id.settings);
    }
    public void loadFragment(Fragment fragment,boolean flag)
    {
//        Bundle bundle=new Bundle();
//        bundle.putString("key","val1");
//        fragment.setArguments(bundle);
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(flag)
            ft.add(R.id.conatiner,fragment);
        else
            ft.replace(R.id.conatiner,fragment);
        ft.commit();
    }
}