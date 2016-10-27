package com.example.klitaviy.viperdaggertest.listeners;

/**
 * Created by klitaviy on 10/13/16.
 */

public interface ReadynessListener {
    /**
     * Called by other class to know is another class (or data) ready to use.
     *
     * @return - boolean
     */
    boolean isReady();
}
