package com.example.recipepuppy.di

import com.example.recipepuppy.network.RecipeService
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface AppComponent {
    fun recipeService(): RecipeService
}