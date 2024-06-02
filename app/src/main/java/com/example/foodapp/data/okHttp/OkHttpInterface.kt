package com.example.foodapp.data.okHttp

import com.example.foodapp.data.okHttp.models.Recipes

interface OkHttpInterface {
    suspend fun getAllRecipes() : Recipes
}