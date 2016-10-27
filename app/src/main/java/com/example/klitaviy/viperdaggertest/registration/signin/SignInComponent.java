package com.example.klitaviy.viperdaggertest.registration.signin;

import com.example.klitaviy.viperdaggertest.data.AppComponent;
import com.example.klitaviy.viperdaggertest.registration.RegistrationModule;
import com.example.klitaviy.viperdaggertest.registration.RegistrationScope;
import com.example.klitaviy.viperdaggertest.registration.signin.view.SignInFragment;

import dagger.Component;

/**
 * Created by klitaviy on 10/17/16.
 */

@Component(dependencies = AppComponent.class, modules = {SignInModule.class, RegistrationModule.class})
@RegistrationScope
public interface SignInComponent {
    void inject(SignInFragment fragment);
}
