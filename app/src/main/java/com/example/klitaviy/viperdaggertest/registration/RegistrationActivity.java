package com.example.klitaviy.viperdaggertest.registration;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.klitaviy.viperdaggertest.R;
import com.example.klitaviy.viperdaggertest.registration.signin.view.SignInFragment;
import com.example.klitaviy.viperdaggertest.registration.signup.view.SignUpFragment;

public class RegistrationActivity extends AppCompatActivity implements Router {

    public static final String TAG = "Dagger2Test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().addOnBackStackChangedListener(
                new FragmentManager.OnBackStackChangedListener() {
                    @Override
                    public void onBackStackChanged() {
                        boolean showBack = getSupportFragmentManager().getBackStackEntryCount() > 0;

                        getSupportActionBar().setDisplayHomeAsUpEnabled(showBack);
                        getSupportActionBar().setDisplayShowHomeEnabled(showBack);
                    }
                }
        );
        goToSignIn();
    }

    @Override
    public void goToSignIn() {
        FragmentManager manager = getSupportFragmentManager();
        manager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        manager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.main_layout,
                        new SignInFragment(),
                        SignInFragment.getFragmentId())
                .commit();
    }

    @Override
    public void goToSignUp() {
        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .add(R.id.main_layout,
                        new SignUpFragment(),
                        SignUpFragment.getFragmentId())
                .addToBackStack(SignInFragment.getFragmentId())
                .commit();
    }
}
