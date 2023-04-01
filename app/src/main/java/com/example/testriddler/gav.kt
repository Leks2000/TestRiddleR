package com.example.testriddler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class gav : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gav)
        var incor: TextView = findViewById(R.id.Incor)
        var cor: TextView = findViewById(R.id.Cor)
        var corrects = intent.getStringExtra("cor")
        var incorrects = intent.getStringExtra("incor")
        incor.text = incorrects.toString()
        cor.text = corrects.toString()
    }

    fun toMain(view: View){
        finish()
    }
}