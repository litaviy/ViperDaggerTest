package com.example.klitaviy.viperdaggertest.registration.signin;

import android.support.annotation.NonNull;

/**
 * Created by klitaviy on 10/13/16.
 */

public interface SignInView {

    void setProgressVisibility(boolean visibility);

    void setLoginEnabled(boolean enabled);

    void showMessage(@NonNull String message);
}
