package com.example.klitaviy.viperdaggertest.registration.signup;

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

public class SignUpPresenter extends SuperPresenter<SignUpView, Router> {

    private SignUpInteractor mInteractor;

    private ActionResultListener mSignUpListener = new ActionResultListener() {
        @Override
        public void onSuccessResult() {
            if (getView() != null) {
                getView().setSignUpEnabled(true);
                getView().setProgressVisibility(false);
                getView().showMessage("Registration Success!");

                /**
                 * Or where you need
                 */
                getRouter().goToSignIn();
            }
        }

        @Override
        public void onFailureResult(@NonNull String error) {
            if (getView() != null) {
                getView().setProgressVisibility(false);
                getView().showMessage(error);
            }
        }
    };
    private ActionResultListener mSignUpListener = new ActionResultListener() {
        @Override
        public void onSuccessResult() {
            if (getView() != null) {
                getView().setSignUpEnabled(true);
                getView().setProgressVisibility(false);
                getView().showMessage("Registration Success!");

                /**
                 * Or where you need
                 */
                getRouter().goToSignIn();
            }
        }

        @Override
        public void onFailureResult(@NonNull String error) {
            if (getView() != null) {
                getView().setProgressVisibility(false);
                getView().showMessage(error);
            }
        }
    };

    @Inject
    public SignUpPresenter(SignUpView signUpView,
                           Router router,
                           SignUpInteractorImpl interactor) {
        super(signUpView, router);
        mInteractor = interactor;
    }

    @Override
    public void onStart(@Nullable Bundle bundle) {

    }

    @Override
    public void onViewReady() {

    }

    @Override
    public void onDestroy() {
        mInteractor.onDestroy();
        mInteractor = null;
        super.onDestroy();
    }

    void signUp(String firstName, String lastName, String email) {
        if (getView() != null) {
            getView().setProgressVisibility(true);
            mInteractor.signUp(mSignUpListener, firstName, lastName, email);
        }
    }
}
