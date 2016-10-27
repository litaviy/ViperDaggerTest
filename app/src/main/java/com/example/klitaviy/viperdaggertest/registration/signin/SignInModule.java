package com.example.klitaviy.viperdaggertest.registration.signin;

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
public class SignInModule {

    private final SignInView mSignInView;

    public SignInModule(SignInView signInView) {
        mSignInView = signInView;
    }

    @Provides
    @NonNull
    @RegistrationScope
    public SignInView provideLoginView() {
        Log.d(RegistrationActivity.TAG, "SignInModule - Provided SignInView.");
        return mSignInView;
    }
}
