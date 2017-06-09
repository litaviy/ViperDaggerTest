package com.example.klitaviy.viperdaggertest.data;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.klitaviy.viperdaggertest.registration.RegistrationComponent;
import com.example.klitaviy.viperdaggertest.registration.RegistrationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by klitaviy on 10/17/16.
 */

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

    RegistrationComponent plusRegistrationComponent(@NonNull final RegistrationModule module);

    Context context();

    DataProvider dataProvider();

    RESTClient restClient();
}
