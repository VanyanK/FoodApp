package com.example.foodapp.data.okHttp.models

import com.google.gson.annotations.SerializedName

data class Recipes(
    @SerializedName("results")
    val results: List<Recipe>,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("number")
    val number: Int,
    @SerializedName("totalResults")
    val totalResults: Int
)