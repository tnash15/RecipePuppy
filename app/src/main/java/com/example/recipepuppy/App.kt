package com.example.recipepuppy

import android.app.Application
import com.example.recipepuppy.di.AppComponent
import com.example.recipepuppy.di.DaggerAppComponent
import dagger.Component

class App : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .build()
    }

    fun getAppComponent() = appComponent
}