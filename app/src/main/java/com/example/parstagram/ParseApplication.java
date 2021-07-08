package com.example.parstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("ursKihtL4H2eQomG2xfanlJIPQ0z1x4SwIWxC5CQ")
                .clientKey("0v4cJ2m5y4RdqcfjyIDkuUpvLOwQB1TXmcOfPqbg")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }

}
