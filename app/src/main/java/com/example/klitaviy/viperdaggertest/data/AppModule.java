package com.example.klitaviy.viperdaggertest.data;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by klitaviy on 10/17/16.
 */

@Module
public class AppModule {

    private Context mContext;

    public AppModule(@NonNull Context context) {
        mContext = context;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return mContext;
    }

    @Provides
    @NonNull
    @Singleton
    public RESTClient provideRESTClient() {
        return new RESTClientImpl();
    }

    @Provides
    @NonNull
    @Singleton
    public DataProvider provideDataProvider() {
        return new DataProviderImpl();
    }
}
