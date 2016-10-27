package com.example.klitaviy.viperdaggertest.common;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.klitaviy.viperdaggertest.listeners.OnDestroyListener;
import com.example.klitaviy.viperdaggertest.listeners.ViewReadyListener;

/**
 * Created by klitaviy on 10/13/16.
 */

public abstract class SuperPresenter<View, Router> implements
        OnDestroyListener,
        ViewReadyListener {

    /**
     * View for Presenter
     */
    private View mView;

    /**
     * Router of module
     */
    private Router mRouter;

    public SuperPresenter(View view, Router router) {
        mView = view;
        mRouter = router;
    }

    public Router getRouter() {
        return mRouter;
    }

    public View getView() {
        return mView;
    }

    /**
     * Called in Fragment.onCreate() to prepare data for View.
     *
     * @param bundle - Bundle for Fragment
     */
    public abstract void onStart(@Nullable Bundle bundle);

    @Override
    public void onDestroy() {
        mView = null;
        mRouter = null;
    }
}
