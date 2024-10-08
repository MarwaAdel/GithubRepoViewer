package com.example.githubrepoviewer

import android.app.Application
import com.example.githubrepoviewer.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class App : Application() {
    init {
        appContext = this
    }
    override fun onCreate() {
        super.onCreate()
        startKoin {
            AndroidLogger(Level.NONE)
            androidContext(this@App)
            modules(appModule)
        }
    }

    companion object {
        lateinit var appContext: App
    }
}