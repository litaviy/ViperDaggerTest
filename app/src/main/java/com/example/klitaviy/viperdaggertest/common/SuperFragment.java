package com.example.klitaviy.viperdaggertest.common;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.klitaviy.viperdaggertest.listeners.Layout;

import java.util.UUID;

/**
 * Created by klitaviy on 10/13/16.
 */

public abstract class SuperFragment extends Fragment {

    private static final UUID FRAGMENT_ID = UUID.randomUUID();

    public static String getFragmentId() {
        return FRAGMENT_ID.toString();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent();
        getPresenter().onStart(getArguments());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Class cls = getClass();
        if (!cls.isAnnotationPresent(Layout.class)) {
            return null;
        }

        Layout layout = (Layout) cls.getAnnotation(Layout.class);
        return inflater.inflate(layout.id(), container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
        getPresenter().onViewReady();
    }

    @Override
    public void onDestroyView() {
        getPresenter().onDestroy();
        super.onDestroyView();
    }

    /**
     * Called to setup Presenter in SuperFragment.
     *
     * @return - SuperPresenterImpl
     */
    @NonNull
    protected abstract SuperPresenter getPresenter();

    /**
     * Called to setup DaggerComponent in subclass
     */
    protected abstract void setupComponent();
}
