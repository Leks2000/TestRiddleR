package com.example.testriddler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Antwort : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.antwort)
    }
    fun tomain(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}