package com.example.klitaviy.viperdaggertest.registration;

import android.support.annotation.NonNull;

import com.example.klitaviy.viperdaggertest.registration.signin.SignInComponent;
import com.example.klitaviy.viperdaggertest.registration.signin.SignInModule;
import com.example.klitaviy.viperdaggertest.registration.signup.SignUpComponent;
import com.example.klitaviy.viperdaggertest.registration.signup.SignUpModule;

import dagger.Subcomponent;

/**
 * Created by klitaviy on 11/8/16.
 */

@Subcomponent(modules = RegistrationModule.class)
@RegistrationScope
public interface RegistrationComponent {

    SignInComponent plusSignInComponent(@NonNull final SignInModule module);

    SignUpComponent plusSignUpComponent(@NonNull final SignUpModule module);
}
