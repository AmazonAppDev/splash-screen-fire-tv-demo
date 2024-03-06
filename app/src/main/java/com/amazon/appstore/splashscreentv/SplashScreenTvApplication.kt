package com.amazon.appstore.splashscreentv

import android.app.Application

class SplashScreenTvApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Thread.sleep(6000)
    }
}