package com.example.klitaviy.viperdaggertest.registration.signin;

import com.example.klitaviy.viperdaggertest.registration.signin.view.SignInFragment;

import dagger.Subcomponent;

/**
 * Created by klitaviy on 10/17/16.
 */

@Subcomponent(modules = SignInModule.class)
@SignInScope
public interface SignInComponent {
    void inject(SignInFragment fragment);
}
