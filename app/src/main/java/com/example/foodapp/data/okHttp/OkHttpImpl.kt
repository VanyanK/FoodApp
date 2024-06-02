package com.example.foodapp.data.okHttp

import android.util.Log
import com.example.foodapp.data.okHttp.models.Recipes
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

object OkHttpImpl : OkHttpInterface {
    val gson = Gson()
    private val client = OkHttpClient()
    override suspend fun getAllRecipes(): Recipes {
        val request = Request.Builder()
            .url("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/complexSearch?")
            .get()
            .addHeader("x-rapidapi-key", "02848dac24msha48dcb9e3125411p1fdc99jsn36b8c69927d4")
            .addHeader("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
            .build()

        try {
            val response = client.newCall(request).execute()
            return gson.fromJson(response.body!!.string(), Recipes::class.java)
        } catch (e : Exception) {
            throw e
        }


    }
}