package com.example.klitaviy.viperdaggertest.data;

import android.os.Handler;
import android.support.annotation.NonNull;

import com.example.klitaviy.viperdaggertest.listeners.ActionResultListener;

/**
 * Created by klitaviy on 10/17/16.
 */

public class RESTClientImpl implements RESTClient {

    private final static String USERNAME = "hello";
    private final static String PASSWORD = "world";

    @Override
    public void signIn(@NonNull final ActionResultListener listener,
                       @NonNull final String userName,
                       @NonNull final String password) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (userName.equals(USERNAME) && password.equals(PASSWORD)) {
                    listener.onSuccessResult();
                } else {
                    listener.onFailureResult("Invalid login!");
                }
            }
        }, 1000);
    }

    @Override
    public void signUp(@NonNull final ActionResultListener listener,
                       @NonNull String firstName,
                       @NonNull String lastName,
                       @NonNull String email) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onSuccessResult();
            }
        }, 1000);
    }
}
