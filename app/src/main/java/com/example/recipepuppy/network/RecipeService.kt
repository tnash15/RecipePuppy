package com.example.recipepuppy.network

import com.example.recipepuppy.model.RecipeResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeService {

    @GET(RecipePuppy_API)
    fun getRecipeResults(@Query("title") title: String): Observable<List<RecipeResponse>>
}