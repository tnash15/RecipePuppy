package com.example.recipepuppy.ui.home.di

import com.example.recipepuppy.di.AppComponent
import com.example.recipepuppy.ui.home.MainActivity
import dagger.Component


@Component(modules = [HomeModule::class], dependencies = [AppComponent::class])
@HomeScope

interface HomeComponent {
    fun inject(mainActivity: MainActivity)
}