package com.example.klitaviy.viperdaggertest.data;

import android.support.annotation.NonNull;

import com.example.klitaviy.viperdaggertest.listeners.ActionResultListener;

/**
 * Created by klitaviy on 10/17/16.
 */

public interface RESTClient {
    void signIn(@NonNull ActionResultListener listener,
                @NonNull String userName,
                @NonNull String password);

    void signUp(@NonNull ActionResultListener listener,
                @NonNull String firstName,
                @NonNull String lastName,
                @NonNull String email);
}
