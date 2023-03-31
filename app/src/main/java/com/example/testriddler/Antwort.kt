package com.example.testriddler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup

class Antwort : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.antwort)
        val btnantw: Button = findViewById(R.id.btnAnt)


        val rdbtns = arrayOf("ant1", "ant2", "ant3","ant4","ant5","ant6","ant7","ant8","ant9","ant10")
        val main = findViewById(R.id.linelay) as LinearLayout
        val rg = RadioGroup(this)
        rg.orientation = RadioGroup.VERTICAL
        for (i in rdbtns.indices) {
            val rb = RadioButton(this)
            rb.text = antworts.random()
            rb.id = View.generateViewId()
            rb.setOnClickListener{
                intent.putExtra("key2", rb.text)
                setResult(RESULT_OK, intent)
                btnantw.isEnabled = true
            }
            rg.addView(rb)
        }
        main.addView(rg)
    }

    val antworts = listOf("Водопровод", "Граммофон", "Календарь", "Крапива", "Машины", "Сапоги", "Магнитофон", "Таракан", "Щетка", "Муравейник", "Наперсток", "Муха", "Паутина", "ладно текст.", "Троллейбус.")

    fun tomain(view: View) {
        finish()
    }

}