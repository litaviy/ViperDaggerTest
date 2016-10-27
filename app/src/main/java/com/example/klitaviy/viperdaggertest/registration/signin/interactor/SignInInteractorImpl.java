package com.example.klitaviy.viperdaggertest.registration.signin.interactor;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.klitaviy.viperdaggertest.data.DataProvider;
import com.example.klitaviy.viperdaggertest.data.RESTClient;
import com.example.klitaviy.viperdaggertest.listeners.ActionResultListener;

import javax.inject.Inject;

/**
 * Created by klitaviy on 10/13/16.
 */

public class SignInInteractorImpl implements SignInInteractor {

    private static final String TAG = SignInInteractorImpl.class.getSimpleName();

    private DataProvider mDataProvider;
    private RESTClient mRESTClient;

    @Inject
    public SignInInteractorImpl(@NonNull DataProvider dataProvider,
                                @NonNull RESTClient RESTClient) {
        mDataProvider = dataProvider;
        mRESTClient = RESTClient;
    }

    @Override
    public void login(@NonNull final ActionResultListener listener,
                      String userName,
                      String password) {

        if (TextUtils.isEmpty(userName)) {
            listener.onFailureResult("Username is empty!");
        } else if (TextUtils.isEmpty(password)) {
            listener.onFailureResult("Password is empty!");
        } else {
            mRESTClient.signIn(new ActionResultListener() {
                @Override
                public void onSuccessResult() {
                    listener.onSuccessResult();
                }

                @Override
                public void onFailureResult(@NonNull String error) {
                    listener.onFailureResult("Invalid login!");
                }
            }, userName, password);
        }
    }
}
