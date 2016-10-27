package com.example.klitaviy.viperdaggertest.registration.signup.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.klitaviy.viperdaggertest.common.SuperPresenterImpl;
import com.example.klitaviy.viperdaggertest.listeners.ActionResultListener;
import com.example.klitaviy.viperdaggertest.registration.Router;
import com.example.klitaviy.viperdaggertest.registration.signup.interactor.SignUpInteractor;
import com.example.klitaviy.viperdaggertest.registration.signup.view.SignUpView;

/**
 * Created by klitaviy on 10/13/16.
 */

public class SignUpPresenterImpl extends SuperPresenterImpl<SignUpView, Router> implements SignUpPresenter {

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

    public SignUpPresenterImpl(SignUpView signUpView,
                               Router router,
                               SignUpInteractor interactor) {
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

    @Override
    public void signUp(String firstName, String lastName, String email) {
        if (getView() != null) {
            getView().setProgressVisibility(true);
            mInteractor.signUp(mSignUpListener, firstName, lastName, email);
        }
    }
}
