package com.example.klitaviy.viperdaggertest.common;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by klitaviy on 10/13/16.
 */

public abstract class SuperPresenterImpl<View, Router> implements
        SuperPresenter {

    /**
     * View for Presenter
     */
    private View mView;

    /**
     * Router of module
     */
    private Router mRouter;

    public SuperPresenterImpl(View view, Router router) {
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

    @Override
    public void onStart(@Nullable Bundle bundle) {

    }

    @Override
    public void onViewReady() {

    }

    @Override
    public void onDestroy() {
        mView = null;
        mRouter = null;
    }
}
