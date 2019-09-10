package com.mundet.origins;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.palette.graphics.Palette;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.appbar.MaterialToolbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetalleMovies extends AppCompatActivity {

    //MaterialToolbar materialToolbar;
    //@BindView(R.id.toolbarDetalleMovie)
    //MaterialToolbar materialToolbar;
    @BindView(R.id.imgMovie)
    ImageView imageView;
    @BindView(R.id.coordinatorDetailMovie)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.toolbarDetalleMovie)
    MaterialToolbar materialToolbar;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_movie);
        ButterKnife.bind(this);

        setSupportActionBar(materialToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Glide.with(getApplicationContext()).asBitmap().load(R.drawable.dog1).into(imageView);

        /*Glide.with(getApplicationContext()).asBitmap().load(R.drawable.week).listener(new RequestListener<Bitmap>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                Palette.from(resource).generate(new Palette.PaletteAsyncListener() {
                    @Override
                    public void onGenerated(@Nullable Palette palette) {
                        Palette.Swatch swatch = palette.getVibrantSwatch();
                        coordinatorLayout.setBackgroundColor(swatch.getRgb());
                    }
                });
                return false;
            }
        }).into(imageView);*/
//                new Target<Drawable>() {
//            @Override
//            public void onLoadStarted(@Nullable Drawable placeholder) {
//                Bitmap bitmap = null;
//                assert imageView != null;
//                imageView.setImageBitmap(bitmap);
//                Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
//                    @Override
//                    public void onGenerated(@Nullable Palette palette) {
//                        //Palette.Swatch swatch = palette.getVibrantSwatch();
//                        //coordinatorLayout.setBackgroundColor(swatch.getRgb());
//                        // imageView.setImageDrawable(swatch.getRgb());
//                    }
//                });
//
//            }
//
//            @Override
//            public void onLoadFailed(@Nullable Drawable errorDrawable) {
//
//            }
//
//            @Override
//            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
//
//            }
//
//            @Override
//            public void onLoadCleared(@Nullable Drawable placeholder) {
//
//            }
//
//            @Override
//            public void getSize(@NonNull SizeReadyCallback cb) {
//
//            }
//
//            @Override
//            public void removeCallback(@NonNull SizeReadyCallback cb) {
//
//            }
//
//            @Override
//            public void setRequest(@Nullable Request request) {
//
//            }
//
//            @Nullable
//            @Override
//            public Request getRequest() {
//                return null;
//            }
//
//            @Override
//            public void onStart() {
//
//            }
//
//            @Override
//            public void onStop() {
//
//            }
//
//            @Override
//            public void onDestroy() {
//
//            }
//        });

        //setSupportActionBar(materialToolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
