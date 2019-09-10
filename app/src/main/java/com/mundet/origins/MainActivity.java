package com.mundet.origins;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btnCrearCuenta)
    MaterialButton materialButton;
    @BindView(R.id.viewPagerActivityMain)
    ViewPager viewPager;
    adapterViewPager adapterViewPager;
    int[] layouts = {R.layout.slide1, R.layout.slide2, R.layout.slide3};
    @BindView(R.id.dots_layouts)
    LinearLayout dots_layout;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        ButterKnife.bind(this);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        adapterViewPager = new adapterViewPager(layouts, this);
        viewPager.setAdapter(adapterViewPager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //event viewPager
        create_dots(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                create_dots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //event button
        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Home.class));
            }
        });

    }

    private void create_dots(int current_posicion) {
        if (dots_layout != null) {
            Log.i("names: ", "create 3");
            dots_layout.removeAllViews();
            dots = new ImageView[layouts.length];

            for (int i = 0; i < layouts.length; i++) {
                Log.i("names: ", "create dots4");
                dots[i] = new ImageView(this);

                if (i == current_posicion) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dots));
                } else {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.default_dots));
                }
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setMargins(4, 0, 4, 0);
                dots_layout.addView(dots[i], params);
            }
        }
    }
}
