package com.example.klitaviy.viperdaggertest.registration.signin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.klitaviy.viperdaggertest.App;
import com.example.klitaviy.viperdaggertest.R;
import com.example.klitaviy.viperdaggertest.common.SuperFragment;
import com.example.klitaviy.viperdaggertest.common.SuperPresenter;
import com.example.klitaviy.viperdaggertest.listeners.Layout;
import com.example.klitaviy.viperdaggertest.registration.RegistrationModule;
import com.example.klitaviy.viperdaggertest.registration.Router;

import javax.inject.Inject;

/**
 * Created by klitaviy on 10/13/16.
 */

@Layout(id = R.layout.fr_login)
public class SignInFragment extends SuperFragment implements SignInView {

    @Inject
    SignInPresenter mPresenter;

    private Button mLoginButton;
    private EditText mUsername, mPassword;
    private ProgressBar mProgressBar;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mUsername = (EditText) view.findViewById(R.id.login_username);
        mPassword = (EditText) view.findViewById(R.id.login_password);
        mLoginButton = (Button) view.findViewById(R.id.login_action);
        mProgressBar = (ProgressBar) view.findViewById(R.id.login_progress);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onLoginClick(
                        mUsername.getText().toString(),
                        mPassword.getText().toString()
                );
            }
        });
        view.findViewById(R.id.login_sign_up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onSignUpClick();
            }
        });
    }

    @NonNull
    @Override
    protected SuperPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected void setupComponent() {
        DaggerSignInComponent.builder()
                .appComponent(App.getAppComponent())
                .signInModule(new SignInModule(this))
                .registrationModule(new RegistrationModule((Router) getActivity()))
                .build()
                .inject(this);
    }

    @Override
    public void setProgressVisibility(boolean visibility) {
        mProgressBar.setVisibility(
                visibility ? View.VISIBLE : View.INVISIBLE
        );
    }

    @Override
    public void setLoginEnabled(boolean enabled) {
        mLoginButton.setEnabled(enabled);
    }

    @Override
    public void showMessage(@NonNull String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
