package com.example.testriddler

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.testriddler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        riddle = findViewById(R.id.secatct)
        activ = findViewById(R.id.secondActivity)
        statistic = findViewById(R.id.statistic)
        startbtn = findViewById(R.id.Startrepeat)
        closepr = findViewById(R.id.ClosePr)
        timetoResult = findViewById(R.id.yourAnswer)
        nonul = findViewById(R.id.yourAnswer2)
        tonull = findViewById(R.id.yourAnswer3)
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
    private lateinit var nonul: TextView
    private lateinit var tonull: TextView
    private lateinit var statistic: Button
    private lateinit var startbtn: Button
    private lateinit var closepr: Button
    private lateinit var timetoResult: TextView
    private lateinit var riddleQuestions: TextView
    var counter = 0
    var cor = 0
    var incor = 0
    var quest = 0

    fun clickAtRiddle(view: View){
        riddleQuestions.text = riddles.random()
        quest = riddles.indexOf(riddleQuestions.text)
        answer.setBackgroundColor(Color.WHITE)
        riddle.isEnabled = false
        activ.isEnabled = true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 100 && resultCode == RESULT_OK && data != null){
            var text = data.getStringExtra("key2")
            var check = data.getStringExtra("key")


            answer.text = text
            if (check == quest.toString()){
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
                startbtn.isVisible = true
                closepr.isVisible = true
                binding.secondActivity.isVisible = false
                binding.secatct.isVisible = false
                answer.text = ""
                riddleQuestions.text = ""
                nonul.text = ""
                tonull.text = ""
            }
            activ.isEnabled = false
            riddle.isEnabled = true
        }
    }

    fun statistic(view: View){
        val iin = Intent(this, gav::class.java)
        iin.putExtra("cor", cor.toString())
        iin.putExtra("incor", incor.toString())
        startActivityForResult(iin, 100)
    }
    fun mainAct(view: View) {
        val i = Intent(this, Antwort::class.java)
        i.putExtra("indexofquest", quest.toString())
        startActivityForResult(i, 100)
    }
    fun close(view: View){
        finish()
    }
    fun reboot(view: View){
        finish();
        startActivity(getIntent())
    }
}
