package com.serioussem.globaltestproject.app

import android.app.Application
import com.serioussem.globaltestproject.di.appModule
import com.serioussem.globaltestproject.di.dataModule
import com.serioussem.globaltestproject.di.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(
                listOf(
                    appModule,
                    dataModule,
                    retrofitModule
                )
            )
        }
    }
}