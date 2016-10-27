package com.example.klitaviy.viperdaggertest.registration.signup.view;

import android.support.annotation.NonNull;

/**
 * Created by klitaviy on 10/13/16.
 */

public interface SignUpView {

    void setProgressVisibility(boolean visibility);

    void setSignUpEnabled(boolean enabled);

    void showMessage(@NonNull String message);
}
