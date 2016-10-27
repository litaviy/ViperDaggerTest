package com.example.klitaviy.viperdaggertest.registration.signup.presenter;

import com.example.klitaviy.viperdaggertest.common.SuperPresenter;

/**
 * Created by klitaviy on 10/27/16.
 */

public interface SignUpPresenter extends SuperPresenter {
    void signUp(String firstName, String lastName, String email);
}
