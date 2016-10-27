package com.example.klitaviy.viperdaggertest.data;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by klitaviy on 10/17/16.
 */

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    Context context();

    DataProvider dataProvider();

    RESTClient restClient();
}
