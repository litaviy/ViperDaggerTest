package com.example.klitaviy.viperdaggertest;

import android.app.Application;

import com.example.klitaviy.viperdaggertest.data.ComponentsProvider;
import com.example.klitaviy.viperdaggertest.data.ComponentsProviderImpl;

/**
 * Created by klitaviy on 10/17/16.
 */

public class App extends Application {

    private static ComponentsProvider sComponentsProvider;

    public static ComponentsProvider getComponentsProvider() {
        return sComponentsProvider;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sComponentsProvider = new ComponentsProviderImpl(this);
    }
}
