package com.example.klitaviy.viperdaggertest.registration;

import android.support.annotation.NonNull;
import android.util.Log;

import dagger.Module;
import dagger.Provides;

/**
 * Created by klitaviy on 10/26/16.
 */

@Module
public class RegistrationModule {

    private final Router mRouter;

    public RegistrationModule(Router router) {
        mRouter = router;
    }

    @Provides
    @NonNull
    @RegistrationScope
    public Router provideRouter() {
        Log.d(RegistrationActivity.TAG, "RegistrationModule - Provided Router.");
        return mRouter;
    }
}
