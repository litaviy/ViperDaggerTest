package com.example.klitaviy.viperdaggertest.registration.signin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.klitaviy.viperdaggertest.common.SuperPresenter;
import com.example.klitaviy.viperdaggertest.listeners.ActionResultListener;
import com.example.klitaviy.viperdaggertest.registration.Router;

import javax.inject.Inject;

/**
 * Created by klitaviy on 10/13/16.
 */

public class SignInPresenter extends SuperPresenter<SignInView, Router> {

    SignInInteractor mInteractor;
    private ActionResultListener mResultListener = new ActionResultListener() {
        @Override
        public void onSuccessResult() {
            if (getRouter() != null) {
                getView().showMessage("Sign In Success!");
                getView().setProgressVisibility(false);
            }
        }

        @Override
        public void onFailureResult(@NonNull String error) {
            if (getView() != null) {
                getView().setProgressVisibility(false);
                getView().setLoginEnabled(true);
                getView().showMessage(error);
            }

        }
    };

    @Inject
    public SignInPresenter(SignInView view,
                           Router router,
                           SignInInteractorImpl interactor) {
        super(view, router);
        mInteractor = interactor;
    }

    @Override
    public void onDestroy() {
        mInteractor = null;
        super.onDestroy();
    }

    @Override
    public void onStart(@Nullable Bundle bundle) {

    }

    @Override
    public void onViewReady() {

    }

    public void onLoginClick(String userName, String password) {
        if (getView() != null) {
            getView().setProgressVisibility(true);
            getView().setLoginEnabled(false);
            mInteractor.login(mResultListener, userName, password);
        }
    }

    public void onSignUpClick() {
        if (getRouter() != null) {
            getRouter().goToSignUp();
        }
    }
}
