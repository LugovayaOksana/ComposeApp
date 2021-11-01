package com.app.composeapp

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.core.context.GlobalContext

object AppModule {
    private lateinit var koinApp: KoinApplication
    fun init(appContext: Context) {
        koinApp = GlobalContext.startKoin {
            androidLogger()
            androidContext(appContext)
//            modules(
//                coreModule(appContext),
//                networkingModule(appContext),
//                presentationModule(appContext)
//            )
        }
    }
}