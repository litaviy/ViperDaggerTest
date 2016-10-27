package com.example.klitaviy.viperdaggertest.registration.signup;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.klitaviy.viperdaggertest.data.DataProvider;
import com.example.klitaviy.viperdaggertest.data.RESTClient;
import com.example.klitaviy.viperdaggertest.listeners.ActionResultListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

/**
 * Created by klitaviy on 10/13/16.
 */

public class SignUpInteractorImpl implements SignUpInteractor {

    private static final String TAG = SignUpInteractorImpl.class.getSimpleName();

    private DataProvider mDataProvider;
    private RESTClient mRESTClient;

    @Inject
    public SignUpInteractorImpl(DataProvider dataProvider, RESTClient RESTClient) {
        mDataProvider = dataProvider;
        mRESTClient = RESTClient;
    }

    @Override
    public void signUp(@NonNull final ActionResultListener listener,
                       String firstName,
                       String lastName,
                       String email) {

        if (isEmpty(firstName)) {
            listener.onFailureResult("First Name is too short");
            return;
        } else if (isEmpty(lastName)) {
            listener.onFailureResult("Last Name is too short");
            return;
        } else if (isEmpty(email)) {
            listener.onFailureResult("Email is too short");
            return;
        } else if (!isEmailValid(email)) {
            listener.onFailureResult("Not valid Email");
            return;
        }

        mRESTClient.signUp(new ActionResultListener() {
            @Override
            public void onSuccessResult() {
                listener.onSuccessResult();
            }

            @Override
            public void onFailureResult(@NonNull String error) {
                listener.onFailureResult(error);
            }
        }, firstName, lastName, email);
    }

    private boolean isEmailValid(String email) {
        String regExpn = "^[_a-z0-9-\\+]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        CharSequence inputStr = email;
        Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();
    }

    private boolean isEmpty(String s) {
        return TextUtils.isEmpty(s);
    }

    @Override
    public void onDestroy() {

    }
}
