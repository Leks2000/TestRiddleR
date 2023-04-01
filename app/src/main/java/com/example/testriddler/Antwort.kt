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
        var quest = intent.getStringExtra("indexofquest")
        var rand = antworts.shuffled()
        var count = 0
        val rdbtns = arrayOf("ant1", "ant2", "ant3","ant4","ant5","ant6","ant7","ant8","ant9","ant10")
        val main = findViewById(R.id.linelay) as LinearLayout
        val rg = RadioGroup(this)
        val indexof = antworts.indexOf(rand.toString())

        //antworts.removeAt(rand.toString())

        rg.orientation = RadioGroup.VERTICAL
        for (i in rdbtns.indices) {
            val rb = RadioButton(this)
            rb.text = rand.get(i)
            rb.id = View.generateViewId()
            rb.setOnClickListener{
                var check = antworts.indexOf(rb.text)
                intent.putExtra("key2", rb.text)
                intent.putExtra("key", check.toString())
                intent.putExtra("ant", antworts.size.toString())
                btnantw.isEnabled = true
            }
            rg.addView(rb)
        }
        main.addView(rg)
    }

    val antworts = mutableListOf("Водопровод", "Граммофон", "Календарь", "Крапива", "Машины", "Сапоги", "Магнитофон", "Таракан", "Щетка", "Муравейник", "Наперсток", "Муха", "Паутина", "ладно текст.", "Троллейбус.")

    fun tomain(view: View) {
        setResult(RESULT_OK, intent)
        finish()
    }

}