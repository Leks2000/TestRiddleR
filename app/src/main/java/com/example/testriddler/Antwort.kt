package com.example.testriddler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class Antwort : AppCompatActivity() {

    val antworts = mutableListOf("Водопровод", "Граммофон", "Календарь",
        "Крапива", "Машины", "Сапоги", "Магнитофон", "Таракан",
        "Щетка", "Муравейник", "Наперсток", "Муха",
        "Паутина", "ладно текст.", "Троллейбус.")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.antwort)
        val btnantw: Button = findViewById(R.id.btnAnt)
        var quest = intent.getStringExtra("indexofquest")
        var info = antworts.get(quest!!.toInt())
        var count = 10
        var rand = antworts.shuffled()
        val rdbtns = arrayOf("ant1", "ant2", "ant3","ant4","ant5","ant6","ant7","ant8","ant9","ant10")
        val main = findViewById(R.id.linelay) as LinearLayout
        val rg = RadioGroup(this)
        while (count == 10){
            rand = antworts.shuffled()
            count = 0
            rg.removeAllViews()
            rg.orientation = RadioGroup.VERTICAL
            for (i in rdbtns.indices) {
                val rb = RadioButton(this)
                rb.text = rand.get(i)
                rb.id = View.generateViewId()
                rb.setOnClickListener {
                    var check = antworts.indexOf(rb.text)
                    intent.putExtra("key2", rb.text)
                    intent.putExtra("key", check.toString())
                    btnantw.isEnabled = true
                }
                if (rb.text != info){
                    count++
                }
                rg.addView(rb)
            }
        }
        main.addView(rg)

    }
    fun tomain(view: View) {
        setResult(RESULT_OK, intent)
        finish()
    }

}