package com.example.recipepuppy.ui.home

import com.example.recipepuppy.network.RecipeService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomePresenter (

    private val recipeService: RecipeService,
    private val view: HomeContract.View) : HomeContract.Presenter {


    private val compositeDisposable = CompositeDisposable()

    override fun getRecipe(dishName: String) {
        compositeDisposable.add(recipeService.getRecipeResults(dishName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ view.showRecipe(it) }, { throwable -> view.showError(throwable.message!!) })
        )
    }

    fun stop() {
        compositeDisposable.clear()
    }
}