package com.example.univibe;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends BaseActivity {

    private static final int SPLASH_DELAY = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logo = findViewById(R.id.logoImage);
        ImageView bgImage = findViewById(R.id.bgImage);
        TextView splashTag = findViewById(R.id.splashTag);

        Animation zoomAnim = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        Animation bounceFade = AnimationUtils.loadAnimation(this, R.anim.bounce_fade);
        Animation slideIn = AnimationUtils.loadAnimation(this, R.anim.slide_in_bottom);

        bgImage.startAnimation(zoomAnim);
        logo.startAnimation(bounceFade);

        // Tagline animates slightly after logo
        new Handler().postDelayed(() -> {
            splashTag.startAnimation(slideIn);
            splashTag.setAlpha(1f);
        }, 1500);

        // Transition to login
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            finish();
        }, SPLASH_DELAY);
    }
}
