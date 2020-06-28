package com.example.todo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TodoApplication : Application() {
//    companion object {
//        lateinit var component: AppComponent private set
//    }
//
//    override fun onCreate() {
//        super.onCreate()
//        component = DaggerAppComponent.factory().create(applicationContext)
//    }
}