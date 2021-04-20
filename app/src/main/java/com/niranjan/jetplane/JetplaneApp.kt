package com.niranjan.jetplane

import android.app.Application
import com.niranjan.jetplane.di.appmodule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class JetplaneApp : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@JetplaneApp)
            modules(appmodule)
        }

    }
}