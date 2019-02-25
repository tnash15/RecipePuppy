package com.example.recipepuppy.ui.home.di

import com.example.recipepuppy.network.RecipeService
import com.example.recipepuppy.ui.home.HomeContract
import com.example.recipepuppy.ui.home.HomePresenter
import com.example.recipepuppy.ui.home.MainActivity
import dagger.Module
import dagger.Provides

@Module
class HomeModule (private val view: MainActivity){

    @Provides
    @HomeScope
    fun providesHomePresenter(recipeService: RecipeService): HomeContract.Presenter {
        return HomePresenter(recipeService, view)
    }
}