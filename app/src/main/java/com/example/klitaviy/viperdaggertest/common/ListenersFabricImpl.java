package com.example.klitaviy.viperdaggertest.common;

import android.support.annotation.NonNull;

import com.example.klitaviy.viperdaggertest.listeners.ActionResultListener;
import com.example.klitaviy.viperdaggertest.registration.signin.view.SignInView;

/**
 * Created by klitaviy on 11/25/16.
 */

public class ListenersFabricImpl implements ListenersFabric {

    @Override
    public ActionResultListener provideLoginActionListener(final SignInView view) {
        return new ActionResultListener() {
            @Override
            public void onSuccessResult() {
                if (view != null) {
                    view.showMessage("Sign In Success!");
                    view.setProgressVisibility(false);
                }
            }

            @Override
            public void onFailureResult(@NonNull String error) {
                if (view != null) {
                    view.setProgressVisibility(false);
                    view.setLoginEnabled(true);
                    view.showMessage(error);
                }
            }
        };
    }
}
