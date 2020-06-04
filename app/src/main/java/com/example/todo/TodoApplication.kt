package com.example.todo

import android.app.Application
import com.example.todo.di.AppComponent
import com.example.todo.di.DaggerAppComponent

class TodoApplication : Application() {
    companion object {
        lateinit var component: AppComponent private set
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.factory().create(applicationContext)
    }
}