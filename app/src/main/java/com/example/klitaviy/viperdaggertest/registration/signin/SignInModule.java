package com.example.klitaviy.viperdaggertest.registration.signin;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.klitaviy.viperdaggertest.data.DataProvider;
import com.example.klitaviy.viperdaggertest.data.RESTClient;
import com.example.klitaviy.viperdaggertest.registration.RegistrationActivity;
import com.example.klitaviy.viperdaggertest.registration.RegistrationScope;
import com.example.klitaviy.viperdaggertest.registration.Router;
import com.example.klitaviy.viperdaggertest.registration.signin.interactor.SignInInteractor;
import com.example.klitaviy.viperdaggertest.registration.signin.interactor.SignInInteractorImpl;
import com.example.klitaviy.viperdaggertest.registration.signin.presenter.SignInPresenter;
import com.example.klitaviy.viperdaggertest.registration.signin.presenter.SignInPresenterImpl;
import com.example.klitaviy.viperdaggertest.registration.signin.view.SignInView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by klitaviy on 10/17/16.
 */

@Module
public class SignInModule {

    private final SignInView mSignInView;

    public SignInModule(SignInView signInView) {
        mSignInView = signInView;
    }

    @Provides
    @NonNull
    @RegistrationScope
    public SignInPresenter provideSignInPresenter(@NonNull SignInView view,
                                                  @NonNull Router router,
                                                  @NonNull SignInInteractor interactor) {
        Log.d(RegistrationActivity.TAG, "SignInModule - Provided SignInPresenter.");
        return new SignInPresenterImpl(view, router, interactor);
    }

    @Provides
    @NonNull
    @RegistrationScope
    public SignInInteractor provideSignInInteractor(@NonNull DataProvider dataProvider,
                                                    @NonNull RESTClient RESTClient) {
        Log.d(RegistrationActivity.TAG, "SignInModule - Provided SignInInteractor.");
        return new SignInInteractorImpl(dataProvider, RESTClient);
    }

    @Provides
    @NonNull
    @RegistrationScope
    public SignInView provideSignInView() {
        Log.d(RegistrationActivity.TAG, "SignInModule - Provided SignInView.");
        return mSignInView;
    }
}
