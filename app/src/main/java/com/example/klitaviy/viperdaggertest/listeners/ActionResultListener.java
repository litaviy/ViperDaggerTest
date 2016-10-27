package com.example.klitaviy.viperdaggertest.listeners;

import android.support.annotation.NonNull;

/**
 * Created by klitaviy on 10/13/16.
 */

public interface ActionResultListener {
    void onSuccessResult();

    void onFailureResult(@NonNull String error);
}
