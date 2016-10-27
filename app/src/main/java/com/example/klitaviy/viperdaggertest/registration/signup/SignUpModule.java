package com.example.klitaviy.viperdaggertest.registration.signup;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.klitaviy.viperdaggertest.registration.RegistrationActivity;
import com.example.klitaviy.viperdaggertest.registration.RegistrationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by klitaviy on 10/17/16.
 */

@Module
public class SignUpModule {

    private final SignUpView mSignUpView;

    public SignUpModule(SignUpView signUpView) {
        mSignUpView = signUpView;
    }

    @Provides
    @NonNull
    @RegistrationScope
    public SignUpView provideUserView() {
        Log.d(RegistrationActivity.TAG, "SignUpModule - Provided SignUpView.");
        return mSignUpView;
    }
}
