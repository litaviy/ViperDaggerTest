package com.example.klitaviy.viperdaggertest.registration.signin.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
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
import com.example.klitaviy.viperdaggertest.registration.RegistrationActivity;
import com.example.klitaviy.viperdaggertest.registration.signin.presenter.SignInPresenter;

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
                mPresenter.onSignInClick(
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
    protected void clearReferences() {
        App.getComponentsProvider().clearSignInComponent();
    }

    @Override
    protected void setupComponent() {
        App.getComponentsProvider()
                .plusSignInComponent(this)
                .inject(this);
    }

    @Override
    public void setProgressVisibility(boolean visibility) {
        mProgressBar.setVisibility(
                visibility ? View.VISIBLE : View.INVISIBLE
        );
    }

    @Override
    public void onDestroy() {
        Log.d(RegistrationActivity.TAG, SignInFragment.class.getSimpleName() + " onDestroy() called");
        super.onDestroy();
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
