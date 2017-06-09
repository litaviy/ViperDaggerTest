package com.example.klitaviy.viperdaggertest.registration.signin.presenter;

import com.example.klitaviy.viperdaggertest.common.ListenersFabric;
import com.example.klitaviy.viperdaggertest.listeners.ActionResultListener;
import com.example.klitaviy.viperdaggertest.registration.Router;
import com.example.klitaviy.viperdaggertest.registration.signin.interactor.SignInInteractor;
import com.example.klitaviy.viperdaggertest.registration.signin.view.SignInView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by klitaviy on 11/25/16.
 */
public class SignInPresenterImplTest {

    @Mock
    SignInView view;

    @Mock
    Router router;

    @Mock
    SignInInteractor interactor;

    private ActionResultListener listener;
    private SignInPresenterImpl presenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new SignInPresenterImpl(view, router, interactor, mock(ListenersFabric.class));
        listener = (ActionResultListener) Whitebox.getInternalState(presenter, "mResultListener");
    }

    @Test
    public void test_onSignInClick() {

        String email = "email";
        String pass = "pass";

        presenter.onSignInClick(email, pass);
        verify(view).setProgressVisibility(true);
        verify(view).setLoginEnabled(false);
        verify(interactor).login(any(ActionResultListener.class), eq(email), eq(pass));
    }

    @Test
    public void test_onSignUpClick() {
        presenter.onSignUpClick();
        verify(router).goToSignUp();
    }

    @Test
    public void test_Listener_Success() {

        listener.onSuccessResult();
        verify(view).showMessage("Sign In Success!");
        verify(view).setProgressVisibility(false);
    }

    @Test
    public void test_Listener_Failure() {

        String error = "aloe";

        listener.onFailureResult(error);
        verify(view).setProgressVisibility(false);
        verify(view).setLoginEnabled(true);
        verify(view).showMessage(error);
    }
}