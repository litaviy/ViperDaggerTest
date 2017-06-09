package com.example.klitaviy.viperdaggertest.registration.signup;

import com.example.klitaviy.viperdaggertest.registration.signup.view.SignUpFragment;

import dagger.Subcomponent;

/**
 * Created by klitaviy on 10/17/16.
 */

@Subcomponent(modules = SignUpModule.class)
@SignUpScope
public interface SignUpComponent {
    void inject(SignUpFragment fragment);
}
