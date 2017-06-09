package com.example.klitaviy.viperdaggertest.registration.signin.presenter;

import android.support.annotation.NonNull;

import com.example.klitaviy.viperdaggertest.common.ListenersFabric;
import com.example.klitaviy.viperdaggertest.common.SuperPresenterImpl;
import com.example.klitaviy.viperdaggertest.listeners.ActionResultListener;
import com.example.klitaviy.viperdaggertest.registration.Router;
import com.example.klitaviy.viperdaggertest.registration.signin.interactor.SignInInteractor;
import com.example.klitaviy.viperdaggertest.registration.signin.view.SignInView;

/**
 * Created by klitaviy on 10/13/16.
 */

public class SignInPresenterImpl extends SuperPresenterImpl<SignInView, Router> implements
        SignInPresenter {

    SignInInteractor mInteractor;
    private ListenersFabric mListenersFabric;

    private ActionResultListener mResultListener = new ActionResultListener() {
        @Override
        public void onSuccessResult() {
            if (getView() != null) {
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

    public SignInPresenterImpl(@NonNull SignInView view,
                               @NonNull Router router,
                               @NonNull SignInInteractor interactor) {
        super(view, router);
        mInteractor = interactor;
    }


    public SignInPresenterImpl(@NonNull SignInView view,
                               @NonNull Router router,
                               @NonNull SignInInteractor interactor,
                               @NonNull ListenersFabric listenersFabric) {
        super(view, router);
        mInteractor = interactor;
        mListenersFabric = listenersFabric;
    }

    @Override
    public void onDestroy() {
        mInteractor = null;
        super.onDestroy();
    }

    @Override
    public void onSignInClick(String userName, String password) {
        if (getView() != null) {
            getView().setProgressVisibility(true);
            getView().setLoginEnabled(false);
            mInteractor.login(
                    mResultListener,
                    userName,
                    password);
        }
    }

    @Override
    public void onSignUpClick() {
        if (getRouter() != null) {
            getRouter().goToSignUp();
        }
    }
}
