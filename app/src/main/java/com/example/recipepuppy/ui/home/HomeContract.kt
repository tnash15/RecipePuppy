package com.example.recipepuppy.ui.home

import com.example.recipepuppy.model.RecipeResponse

class HomeContract {

    interface View {
        fun showRecipe(results: List<RecipeResponse>)
        fun showError(message: String)
    }

    interface Presenter {
        fun getRecipe(dishName: String)
    }
}