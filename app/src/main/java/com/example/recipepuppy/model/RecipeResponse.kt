package com.example.recipepuppy.model

import com.google.gson.annotations.SerializedName

data class RecipeResponse(
    @SerializedName("title") val title: String

)