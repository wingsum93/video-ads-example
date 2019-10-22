package com.example.videoexample

import android.app.Application
import androidx.multidex.MultiDexApplication
import com.facebook.stetho.Stetho

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}