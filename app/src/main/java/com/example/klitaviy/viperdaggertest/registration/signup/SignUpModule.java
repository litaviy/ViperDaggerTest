package com.example.klitaviy.viperdaggertest.registration.signup;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.klitaviy.viperdaggertest.data.DataProvider;
import com.example.klitaviy.viperdaggertest.data.RESTClient;
import com.example.klitaviy.viperdaggertest.registration.RegistrationActivity;
import com.example.klitaviy.viperdaggertest.registration.Router;
import com.example.klitaviy.viperdaggertest.registration.signup.interactor.SignUpInteractor;
import com.example.klitaviy.viperdaggertest.registration.signup.interactor.SignUpInteractorImpl;
import com.example.klitaviy.viperdaggertest.registration.signup.presenter.SignUpPresenter;
import com.example.klitaviy.viperdaggertest.registration.signup.presenter.SignUpPresenterImpl;
import com.example.klitaviy.viperdaggertest.registration.signup.view.SignUpView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by klitaviy on 10/17/16.
 */

@Module
public class SignUpModule {

    private final SignUpView mSignUpView;

    public SignUpModule(SignUpView signUpView) {
        mSignUpView = signUpView;
    }

    @Provides
    @NonNull
    @SignUpScope
    public SignUpPresenter provideSignUpPresenter(@NonNull SignUpView view,
                                                  @NonNull Router router,
                                                  @NonNull SignUpInteractor interactor) {
        Log.d(RegistrationActivity.TAG, "SignUpModule - Provided SignUpPresenter.");
        return new SignUpPresenterImpl(view, router, interactor);
    }

    @Provides
    @NonNull
    @SignUpScope
    public SignUpInteractor provideSignUpInteractor(@NonNull DataProvider dataProvider,
                                                    @NonNull RESTClient client) {
        Log.d(RegistrationActivity.TAG, "SignUpModule - Provided SignUpInteractor.");
        return new SignUpInteractorImpl(dataProvider, client);
    }

    @Provides
    @NonNull
    @SignUpScope
    public SignUpView provideSignUpView() {
        Log.d(RegistrationActivity.TAG, "SignUpModule - Provided SignUpView.");
        return mSignUpView;
    }
}
