package com.example.klitaviy.viperdaggertest.registration.signup.view;

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
import com.example.klitaviy.viperdaggertest.registration.signup.presenter.SignUpPresenter;

import javax.inject.Inject;

/**
 * Created by klitaviy on 10/13/16.
 */

@Layout(id = R.layout.fr_user)
public class SignUpFragment extends SuperFragment implements SignUpView {

    @Inject
    SignUpPresenter mPresenter;

    private Button mAction;
    private EditText mFName, mLName, mEmail;
    private ProgressBar mProgressBar;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAction = (Button) view.findViewById(R.id.sign_up_action);
        mFName = (EditText) view.findViewById(R.id.sign_up_f_name);
        mLName = (EditText) view.findViewById(R.id.sign_up_l_name);
        mEmail = (EditText) view.findViewById(R.id.sign_up_email);
        mProgressBar = (ProgressBar) view.findViewById(R.id.sign_up_progress);

        mAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.signUp(
                        mFName.getText().toString(),
                        mLName.getText().toString(),
                        mEmail.getText().toString()
                );
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
        App.getComponentsProvider().clearSignUpComponent();
    }

    @Override
    protected void setupComponent() {
        App.getComponentsProvider()
                .plusSignUpComponent(this)
                .inject(this);
    }

    @Override
    public void setProgressVisibility(boolean visibility) {
        mProgressBar.setVisibility(
                visibility ? View.VISIBLE : View.GONE
        );
    }

    @Override
    public void onDestroy() {
        Log.d(RegistrationActivity.TAG, SignUpFragment.class.getSimpleName() + " onDestroy() called");
        super.onDestroy();
    }

    @Override
    public void setSignUpEnabled(boolean enabled) {
        mAction.setEnabled(enabled);
    }

    @Override
    public void showMessage(@NonNull String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
