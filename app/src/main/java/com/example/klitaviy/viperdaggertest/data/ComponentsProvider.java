package com.example.klitaviy.viperdaggertest.data;

import android.support.annotation.NonNull;

import com.example.klitaviy.viperdaggertest.registration.RegistrationComponent;
import com.example.klitaviy.viperdaggertest.registration.Router;
import com.example.klitaviy.viperdaggertest.registration.signin.SignInComponent;
import com.example.klitaviy.viperdaggertest.registration.signin.view.SignInView;
import com.example.klitaviy.viperdaggertest.registration.signup.SignUpComponent;
import com.example.klitaviy.viperdaggertest.registration.signup.view.SignUpView;

/**
 * Created by klitaviy on 11/8/16.
 */

public interface ComponentsProvider {
    RegistrationComponent plusRegistrationComponent(@NonNull final Router router);

    void clearRegistrationComponent();

    SignInComponent plusSignInComponent(@NonNull final SignInView view);

    void clearSignInComponent();

    SignUpComponent plusSignUpComponent(@NonNull final SignUpView view);

    void clearSignUpComponent();
}
