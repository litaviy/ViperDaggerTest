package com.example.klitaviy.viperdaggertest.data;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.klitaviy.viperdaggertest.registration.RegistrationComponent;
import com.example.klitaviy.viperdaggertest.registration.RegistrationModule;
import com.example.klitaviy.viperdaggertest.registration.Router;
import com.example.klitaviy.viperdaggertest.registration.signin.SignInComponent;
import com.example.klitaviy.viperdaggertest.registration.signin.SignInModule;
import com.example.klitaviy.viperdaggertest.registration.signin.view.SignInView;
import com.example.klitaviy.viperdaggertest.registration.signup.SignUpComponent;
import com.example.klitaviy.viperdaggertest.registration.signup.SignUpModule;
import com.example.klitaviy.viperdaggertest.registration.signup.view.SignUpView;

/**
 * Created by klitaviy on 11/8/16.
 */

public class ComponentsProviderImpl implements ComponentsProvider {

    private Context mContext;

    private AppComponent mAppComponent;
    private RegistrationComponent mRegistrationComponent;
    private SignInComponent mSignInComponent;
    private SignUpComponent mSignUpComponent;

    public ComponentsProviderImpl(Context context) {
        mContext = context;
        buildAppComponent();
    }

    protected void buildAppComponent() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(mContext))
                .build();
    }

    public RegistrationComponent plusRegistrationComponent(@NonNull final Router router) {
        if (mRegistrationComponent == null) {
            mRegistrationComponent = mAppComponent.plusRegistrationComponent(
                    new RegistrationModule(router)
            );
        }
        return mRegistrationComponent;
    }

    public void clearRegistrationComponent() {
        mRegistrationComponent = null;
    }

    public SignInComponent plusSignInComponent(@NonNull final SignInView view) {
        if (mSignInComponent == null) {
            mSignInComponent = mRegistrationComponent.plusSignInComponent(
                    new SignInModule(view)
            );
        }
        return mSignInComponent;
    }

    public void clearSignInComponent() {
        mSignInComponent = null;
    }

    public SignUpComponent plusSignUpComponent(@NonNull final SignUpView view) {
        if (mSignUpComponent == null) {
            mSignUpComponent = mRegistrationComponent.plusSignUpComponent(
                    new SignUpModule(view)
            );
        }
        return mSignUpComponent;
    }

    public void clearSignUpComponent() {
        mSignUpComponent = null;
    }

}
