package com.example.testriddler

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.testriddler.databinding.ActivityMainBinding
import java.util.*

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
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        riddle = findViewById(R.id.secatct)
        activ = findViewById(R.id.secondActivity)
        statistic = findViewById(R.id.statistic)
        timetoResult = findViewById(R.id.yourAnswer)
        answer = findViewById(R.id.yourAnswer3)
        riddleQuestions = findViewById(R.id.riddleQuestions)
    }

    val riddles = listOf("Речка спятила с ума - По домам пошла сама.","Музыкант, певец, рассказчик — А всего труба да ящик.","На раскрашенных страницах Много праздников хранится.",
        "Ах, не трогайте меня: Обожгу и без огня!","Маленькие домики по улице бегут, Мальчиков и девочек домики везут.",
        "Пустые отдыхаем, А полные шагаем.","Нет ушей, а слышит. Нету рук, а пишет.","Над нами кверху ногами.","Деревянный брусок, А на нем растет лесок.",
        "В лесу без огня котел кипит.","На ямке, ямке сто ямок с ямкой.","Кто над нами вверх ногами?","В углу сито, не руками вито.",
        "Было 4 овцы как","Что это такое: синий, большой, с усами и набит зайцами?")

    private lateinit var riddle: Button
    private lateinit var activ: Button
    private lateinit var answer: TextView
    private lateinit var statistic: Button
    private lateinit var timetoResult: TextView
    private lateinit var riddleQuestions: TextView
    var counter = 0
    var cor = 0
    var incor = 0


    fun clickAtRiddle(view: View){
        riddleQuestions.text = riddles.random()
        answer.setBackgroundColor(Color.WHITE)
        riddle.isEnabled = false
        activ.isEnabled = true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 100 && resultCode == RESULT_OK && data != null){
            var text = data.getStringExtra("key2")
            answer.text = text
            if (cor == incor){
                cor++
                answer.setBackgroundColor(Color.GREEN)
            }else{
                incor++
                answer.setBackgroundColor(Color.RED)
            }
            counter++
            timetoResult.text = counter.toString() + "/10"
            if (counter == 10){
                statistic.isEnabled = true
                riddle.isEnabled = false
            }
            activ.isEnabled = false
            riddle.isEnabled = true
        }
    }


    fun mainAct(view: View) {
        val i = Intent(this, Antwort::class.java)
        startActivityForResult(i, 100)
    }
}
