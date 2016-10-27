package com.example.klitaviy.viperdaggertest.registration.signin.interactor;

import android.support.annotation.NonNull;

import com.example.klitaviy.viperdaggertest.listeners.ActionResultListener;

/**
 * Created by klitaviy on 10/13/16.
 */

public interface SignInInteractor {

    void login(@NonNull ActionResultListener listener,
               String userName,
               String password);
}
