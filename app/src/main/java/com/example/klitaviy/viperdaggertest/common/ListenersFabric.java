package com.example.klitaviy.viperdaggertest.common;

import com.example.klitaviy.viperdaggertest.listeners.ActionResultListener;
import com.example.klitaviy.viperdaggertest.registration.signin.view.SignInView;

/**
 * Created by klitaviy on 11/25/16.
 */

public interface ListenersFabric {
    ActionResultListener provideLoginActionListener(final SignInView view);
}
