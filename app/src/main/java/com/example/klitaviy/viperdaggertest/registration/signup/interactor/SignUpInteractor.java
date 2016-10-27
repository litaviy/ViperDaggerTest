package com.example.klitaviy.viperdaggertest.registration.signup.interactor;

import android.support.annotation.NonNull;

import com.example.klitaviy.viperdaggertest.listeners.ActionResultListener;
import com.example.klitaviy.viperdaggertest.listeners.OnDestroyListener;

/**
 * Created by klitaviy on 10/13/16.
 */

public interface SignUpInteractor extends
        OnDestroyListener {
    void signUp(@NonNull ActionResultListener listener,
                String firstName,
                String lastName,
                String email);
}
