package com.example.bookwala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class startup extends AppCompatActivity {
    //variables
    private static int splash_screen = 3000;
    Animation top_anim,bottom_anim;
    ImageView image;
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_startup);
        //Animations
        top_anim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom_anim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //hooks
        image = findViewById(R.id.imageView);
        name = findViewById(R.id.textView);

        //setting animation
        image.setAnimation(top_anim);
        name.setAnimation(bottom_anim);

        //splash screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent1 = new Intent(startup.this,Login.class);
                startActivity(intent1);
                finish();
            }
        },splash_screen);
    }
}