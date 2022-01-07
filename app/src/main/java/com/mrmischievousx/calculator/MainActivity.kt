package com.mrmischievousx.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.notkamui.keval.Keval

class MainActivity : AppCompatActivity() {
    private var ansText = ""
    lateinit var ans: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button0 = findViewById<Button>(R.id.button_0)
        button0.setOnClickListener() {
            updateAnsText("0")
        }
        val button1 = findViewById<Button>(R.id.button_1)
        button1.setOnClickListener() {
            updateAnsText("1")
        }
        val button2 = findViewById<Button>(R.id.button_2)
        button2.setOnClickListener() {
            updateAnsText("2")
        }
        val button3 = findViewById<Button>(R.id.button_3)
        button3.setOnClickListener() {
            updateAnsText("3")
        }
        val button4 = findViewById<Button>(R.id.button_4)
        button4.setOnClickListener() {
            updateAnsText("4")
        }
        val button5 = findViewById<Button>(R.id.button_5)
        button5.setOnClickListener() {
            updateAnsText("5")
        }
        val button6 = findViewById<Button>(R.id.button_6)
        button6.setOnClickListener() {
            updateAnsText("6")
        }
        val button7 = findViewById<Button>(R.id.button_7)
        button7.setOnClickListener() {
            updateAnsText("7")
        }
        val button8 = findViewById<Button>(R.id.button_8)
        button8.setOnClickListener() {
            updateAnsText("8")
        }
        val button9 = findViewById<Button>(R.id.button_9)
        button9.setOnClickListener() {
            updateAnsText("9")
        }
        val add = findViewById<Button>(R.id.button_plus)
        add.setOnClickListener() {
            updateAnsText("+")
        }
        val sub = findViewById<Button>(R.id.button_minus)
        sub.setOnClickListener() {
            updateAnsText("-")
        }
        val multiply = findViewById<Button>(R.id.button_multiply)
        multiply.setOnClickListener() {
            updateAnsText("*")
        }
        val divide = findViewById<Button>(R.id.button_divide)
        divide.setOnClickListener() {
            updateAnsText("/")
        }
        val percentage = findViewById<Button>(R.id.button_percentage)
        percentage.setOnClickListener() {
            updateAnsText("%")
        }

        val equal = findViewById<Button>(R.id.button_eq)
        equal.setOnClickListener() {
            calculate()
        }

        val clear = findViewById<Button>(R.id.button_clr)
        clear.setOnClickListener() {
            clear()
        }

        val delete = findViewById<Button>(R.id.button_del)
        delete.setOnClickListener() {
            clearOne()
        }

        ans = findViewById<TextView>(R.id.ans)
    }

    private fun updateAnsText(str: String) {
        if (ans.text == "Error") {
            ansText = str
        } else {
            ansText += str
        }
        ans.text = ansText
    }

    private fun calculate() {
        ansText = try {
            Keval.eval(ansText).toString()
        } catch (e: Exception) {
            "Error"
        }
        ans.text = ansText
    }

    private fun clear() {
        ans.text = ""
    }

    private fun clearOne() {
        if (ansText.isNotEmpty()) {
            ansText = ansText.substring(0, ansText.length - 1)
            ans.text = ansText
        }
    }
}