package com.app.composeapp

import android.app.Application
import timber.log.Timber

class App: Application(){

    override fun onCreate() {
        super.onCreate()
        setupLogger()
        AppModule.init(this)
    }

    private fun setupLogger() {
        Timber.plant(Timber.DebugTree())
    }
}