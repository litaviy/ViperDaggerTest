package com.example.klitaviy.viperdaggertest.registration.signup;

import com.example.klitaviy.viperdaggertest.data.AppComponent;
import com.example.klitaviy.viperdaggertest.registration.RegistrationModule;
import com.example.klitaviy.viperdaggertest.registration.RegistrationScope;
import com.example.klitaviy.viperdaggertest.registration.signup.view.SignUpFragment;

import dagger.Component;

/**
 * Created by klitaviy on 10/17/16.
 */

@Component(dependencies = AppComponent.class, modules = {SignUpModule.class, RegistrationModule.class})
@RegistrationScope
public interface SignUpComponent {
    void inject(SignUpFragment fragment);
}
