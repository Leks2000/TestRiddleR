package com.example.testriddler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.lang.Math.random
import kotlin.random.Random

/*
1-Водопровод
2-Граммофон
3-Календарь
4-Крапива
5-Машины
6-Сапоги
7-Магнитофон
8-Таракан
9-Щетка
10-Муравейник
11-Наперсток
12-Муха
13-Паутина
14-ладно текст.
15-Троллейбус.
*/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        riddle = findViewById(R.id.secatct)
        riddleQuestions = findViewById(R.id.riddleQuestions)
    }
    private lateinit var riddle: TextView
    private lateinit var riddleQuestions: TextView
    fun clickAtRiddle(view: View){
        val riddles = listOf("Речка спятила с ума - По домам пошла сама.","Музыкант, певец, рассказчик — А всего труба да ящик.","На раскрашенных страницах Много праздников хранится.",
            "Ах, не трогайте меня: Обожгу и без огня!","Маленькие домики по улице бегут, Мальчиков и девочек домики везут.",
            "Пустые отдыхаем, А полные шагаем.","Нет ушей, а слышит. Нету рук, а пишет.","Над нами кверху ногами.","Деревянный брусок, А на нем растет лесок.",
            "В лесу без огня котел кипит.","На ямке, ямке сто ямок с ямкой.","Кто над нами вверх ногами?","В углу сито, не руками вито.",
            "Было 4 овцы как","Что это такое: синий, большой, с усами и набит зайцами?")
            riddleQuestions.text = riddles.random()
        riddle.isEnabled = false
    }
    fun mainAct(view: View) {
        val intent = Intent(this, Antwort::class.java)
        startActivity(intent)
        riddle.isEnabled = true
    }


}
