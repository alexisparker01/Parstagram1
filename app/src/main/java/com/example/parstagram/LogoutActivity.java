package com.example.parstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.ParseUser;

public class LogoutActivity extends AppCompatActivity {

    Button btnLogout;
    ImageView insta;
    ImageView profile;
    ImageView cam;
    ImageView cam2;
    ImageView feed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        btnLogout = findViewById(R.id.btnLogout);
        insta = findViewById(R.id.InstaTop);
        profile = findViewById(R.id.profile);
        cam = findViewById(R.id.cam);
        cam2 = findViewById(R.id.cam2);
        feed = findViewById(R.id.feed);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LogoutActivity.this, LogoutActivity.class);
                startActivity(i);

            }
        });

        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cam.setImageResource(R.drawable.camera_shadow_fill);
                Intent i = new Intent(LogoutActivity.this, MainActivity.class);
                startActivity(i);

            }
        });

        cam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(LogoutActivity.this, MainActivity.class);
                startActivity(i);

            }
        });


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });


        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LogoutActivity.this, FeedActivity.class);
                startActivity(i);
            }
        });

    }
    public void logoutUser() {
        ParseUser.logOut();
        Intent i = new Intent(LogoutActivity.this, LoginActivity.class);
        startActivity(i);
        finish();

    }
}