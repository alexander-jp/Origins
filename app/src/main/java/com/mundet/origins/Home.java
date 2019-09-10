package com.mundet.origins;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.airbnb.lottie.LottieAnimationView;
import com.fxn.BubbleTabBar;
import com.fxn.OnBubbleClickListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mundet.origins.fragments.fragmentHome;
import com.mundet.origins.fragments.fragmetRenta;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Home extends AppCompatActivity {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @BindView(R.id.framelayout)
    FrameLayout frameLayout;
    @BindView(R.id.bubbleTabBar)
    BubbleTabBar bubbleTabBar;
    LottieAnimationView lottieAnimationView;

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        ButterKnife.bind(this);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.framelayout, new fragmentHome()).commit();
        bubbleTabBar.addBubbleListener(new OnBubbleClickListener() {
            @Override
            public void onBubbleClick(int id) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                switch (id) {
                    case R.id.inicio_menu:
                        fragmentManager.beginTransaction().replace(R.id.framelayout, new fragmentHome()).commit();
                        break;
                    case R.id.favorito_menu:
                        fragmentManager.beginTransaction().replace(R.id.framelayout, new fragmentHome()).commit();
                        break;
                    case R.id.configuracion_menu:
                        fragmentManager.beginTransaction().replace(R.id.framelayout, new fragmetRenta()).commit();
                        break;
                    case R.id.profile_menu:
                        fragmentManager.beginTransaction().replace(R.id.framelayout, new fragmetRenta()).commit();
                        break;
                }

            }
        });
/*        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.inicio_menu) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.framelayout, new fragmentHome()).commit();
                    item.setCheckable(true);
                    item.setChecked(true);
                } else if (id == R.id.renta_menu) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.framelayout, new fragmetRenta()).commit();
                    item.setCheckable(true);
                    item.setChecked(true);
                } else if (id == R.id.favorito_menu) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.framelayout, new fragmentHome()).commit();
                    item.setCheckable(true);
                    item.setChecked(true);
                } else if (id == R.id.configuracion_menu) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.framelayout, new fragmetRenta()).commit();
                    item.setCheckable(true);
                    item.setChecked(true);
                }
                return false;
            }
        });*/
    }

}
