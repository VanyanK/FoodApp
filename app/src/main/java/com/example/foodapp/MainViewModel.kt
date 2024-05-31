package com.example.foodapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class MainViewModel: ViewModel() {
    val client = OkHttpClient()

    fun pizdec() {
        viewModelScope.launch { // запуск корутина с привязкой к жизненному циклу
            try {
                run(client)  // вызов долго выполняющейся функции
            } catch (e: IOException) {
                e.printStackTrace()
                // Обработка ошибки, например, показать пользователю сообщение
            }
        }
    }

    private suspend fun run(client: OkHttpClient) {
        val request = Request.Builder()
            .url("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/complexSearch?")
            .get()
            .addHeader("x-rapidapi-key","02848dac24msha48dcb9e3125411p1fdc99jsn36b8c69927d4")
            .addHeader("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
            .build()

        withContext(Dispatchers.IO) {
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) throw IOException("Unexpected code $response")
                Log.i("BLYAD", "${response.body!!.string()}")
            }
        }
    }
}