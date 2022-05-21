package com.example.coffeemaps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_CoffeeMaps)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val title: TextView = findViewById(R.id.title)
        title.text = intent.getSerializableExtra("title").toString()
    }
}