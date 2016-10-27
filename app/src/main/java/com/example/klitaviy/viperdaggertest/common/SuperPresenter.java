package com.example.klitaviy.viperdaggertest.common;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.klitaviy.viperdaggertest.listeners.OnDestroyListener;
import com.example.klitaviy.viperdaggertest.listeners.ViewReadyListener;

/**
 * Created by klitaviy on 10/27/16.
 */

public interface SuperPresenter extends
        OnDestroyListener,
        ViewReadyListener {
    void onStart(@Nullable Bundle bundle);
}
