package com.example.legi_info

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class LegiInfoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Logger.addLogAdapter(AndroidLogAdapter())
        AndroidThreeTen.init(this)
        startKoin {
            androidContext(this@LegiInfoApplication)
            modules(appModule)
        }
    }
}