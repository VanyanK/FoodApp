package com.example.foodapp.presentation

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.foodapp.R
import com.example.foodapp.presentation.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {

    val viewModel : MainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        viewModel.response.observe(this, Observer { response ->
            // Обновляем TextView или другой элемент UI с данными
            val tv = findViewById<TextView>(R.id.tv)
            tv.text = response.results[0].title
        })

        viewModel.vm()

    }
}