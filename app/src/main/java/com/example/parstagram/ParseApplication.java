package com.example.parstagram;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("ursKihtL4H2eQomG2xfanlJIPQ0z1x4SwIWxC5CQ")
                .clientKey("0v4cJ2m5y4RdqcfjyIDkuUpvLOwQB1TXmcOfPqbg")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
