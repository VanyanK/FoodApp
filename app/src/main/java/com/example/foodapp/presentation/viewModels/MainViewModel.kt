package com.example.foodapp.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.data.okHttp.OkHttpImpl
import com.example.foodapp.data.okHttp.models.Recipes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class MainViewModel: ViewModel() {

    private val _response = MutableLiveData<Recipes>()
    val response: LiveData<Recipes> get() = _response


    fun vm() {
        viewModelScope.launch { // запуск корутина с привязкой к жизненному циклу
            try {
                withContext(Dispatchers.IO) {
                    val response = OkHttpImpl.getAllRecipes()
                    Log.i("CRAZY", response.toString())
                    _response.postValue(response)
                }
            } catch (e: IOException) {
                e.printStackTrace()
                // Обработка ошибки, например, показать пользователю сообщение
            }
        }
    }



}