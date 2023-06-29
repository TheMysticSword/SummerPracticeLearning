package com.example.summerpracticelearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var inputName:EditText? = null
    var inputHeight:EditText? = null
    var inputWeight:EditText? = null
    var inputAge:EditText? = null

    var resultText:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputName = findViewById(R.id.input_name)
        inputHeight = findViewById(R.id.input_height)
        inputWeight = findViewById(R.id.input_weight)
        inputAge = findViewById(R.id.input_age)
        resultText = findViewById(R.id.text_result)

        val mainButton = findViewById<Button>(R.id.button_main)
        mainButton.setOnClickListener { onClick(it) }
    }

    fun onClick(view: View)
    {
        fun invalidEntriesError() {
            resultText?.text = getString(R.string.output_invalid_input_error)
        }

        val name = inputName?.text.toString()
        if (name.length == 0) return invalidEntriesError()

        val height = inputHeight?.text.toString().toInt()
        if (height <= 0 || height >= 250) return invalidEntriesError()

        val weight = inputWeight?.text.toString().toFloat()
        if (weight <= 0 || weight >= 250) return invalidEntriesError()

        val age = inputAge?.text.toString().toInt()
        if (age <= 0 || age >= 150) return invalidEntriesError()

        var wizFirstName = ""
        if (wizFirstNameMatches.containsKey(name[0]))
            wizFirstName = wizFirstNameMatches.get(name[0]).toString()
        else
            wizFirstName = wizFirstNameMatches.values.random()

        var wizPrefix = ""
        if (age >= 10 && age < 18)
            wizPrefix = "Дека"
        else if (age >= 18 && age < 27)
            wizPrefix = "Омни"
        else if (age >= 27 && age < 40)
            wizPrefix = "Гран"
        else if (age >= 40)
            wizPrefix = "Архи"

        var wizSuffix = "магус"
        val suffixCoeff = height * weight
        if (suffixCoeff <= (110*20))
            wizSuffix = "гор"
        else if (suffixCoeff <= (120*30))
            wizSuffix = "вариус"
        else if (suffixCoeff <= (130*40))
            wizSuffix = "дор"
        else if (suffixCoeff <= (140*40))
            wizSuffix = "дорф"
        else if (suffixCoeff <= (140*50))
            wizSuffix = "бар"
        else if (suffixCoeff <= (150*60))
            wizSuffix = "мон"
        else if (suffixCoeff <= (160*60))
            wizSuffix = "морт"

        if (wizPrefix.isNotEmpty())
            wizFirstName = wizFirstName.lowercase()

        var value = wizPrefix + wizFirstName + wizSuffix
        resultText?.text = "Ответ: $value"
    }

    var wizFirstNameMatches:Map<Char, String> = mapOf(
        'А' to "Андре",
        'Б' to "Бартоло",
        'В' to "Васили",
        'Г' to "Гаруда",
        'Д' to "Димитри",
        'Е' to "Елисто",
        'Ж' to "Жоан",
        'З' to "Земле",
        'И' to "Иллири",
        'К' to "Корро",
        'Л' to "Лимбо",
        'М' to "Мана",
        'Н' to "Нано",
        'О' to "Окулус",
        'П' to "Престо",
        'Р' to "Рассел",
        'С' to "Сайру",
        'Т' to "Тенно",
        'У' to "Умбра",
        'Ф' to "Ферро",
        'Х' to "Ханна",
        'Ц' to "Цар",
        'Ч' to "Чайл",
        'Ш' to "Шайно",
        'Э' to "Эмилли",
        'Ю' to "Юрго",
        'Я' to "Ярон"
    )
}