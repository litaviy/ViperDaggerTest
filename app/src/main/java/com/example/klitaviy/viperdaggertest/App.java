package com.example.klitaviy.viperdaggertest;

import android.app.Application;

import com.example.klitaviy.viperdaggertest.data.AppComponent;
import com.example.klitaviy.viperdaggertest.data.AppModule;
import com.example.klitaviy.viperdaggertest.data.DaggerAppComponent;

/**
 * Created by klitaviy on 10/17/16.
 */

public class App extends Application {

    private static AppComponent sAppComponent;

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sAppComponent = buildAppComponent();
    }

    protected AppComponent buildAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
