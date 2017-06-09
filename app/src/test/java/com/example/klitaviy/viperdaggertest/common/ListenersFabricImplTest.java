package com.example.klitaviy.viperdaggertest.common;

import com.example.klitaviy.viperdaggertest.listeners.ActionResultListener;
import com.example.klitaviy.viperdaggertest.registration.signin.view.SignInView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * Created by klitaviy on 11/25/16.
 */
public class ListenersFabricImplTest {

    @Mock
    SignInView view;

    ListenersFabric mFabric;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mFabric = new ListenersFabricImpl();
    }

    @Test
    public void test_LoginActionListenerSuccess() throws Exception {
        ActionResultListener listener = mFabric.provideLoginActionListener(view);

        listener.onSuccessResult();
        verify(view).showMessage("Sign In Success!");
        verify(view).setProgressVisibility(false);
    }

    @Test
    public void test_LoginActionListenerFailure() throws Exception {
        ActionResultListener listener = mFabric.provideLoginActionListener(view);

        String error = "aloe";

        listener.onFailureResult(error);
        verify(view).setProgressVisibility(false);
        verify(view).setLoginEnabled(true);
        verify(view).showMessage(error);
    }
}