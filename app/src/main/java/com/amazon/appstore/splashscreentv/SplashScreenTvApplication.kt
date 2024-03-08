// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0


package com.amazon.appstore.splashscreentv

import android.app.Application

class SplashScreenTvApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Thread.sleep(6000)
    }
}