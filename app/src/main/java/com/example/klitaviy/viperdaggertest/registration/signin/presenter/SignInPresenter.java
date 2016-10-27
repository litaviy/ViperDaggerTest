package com.example.klitaviy.viperdaggertest.registration.signin.presenter;

import com.example.klitaviy.viperdaggertest.common.SuperPresenter;

/**
 * Created by klitaviy on 10/27/16.
 */

public interface SignInPresenter extends SuperPresenter {
    void onSignInClick(String userName, String password);

    void onSignUpClick();
}
