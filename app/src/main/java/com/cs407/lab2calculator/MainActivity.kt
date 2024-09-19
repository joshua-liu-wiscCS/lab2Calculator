package com.cs407.lab2calculator

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val firstInput = findViewById<EditText>(R.id.FirstNumber)
        firstInput.inputType = InputType.TYPE_CLASS_NUMBER
        val secondInput = findViewById<EditText>(R.id.SecondNumber)
        secondInput.inputType = InputType.TYPE_CLASS_NUMBER

        val addition = findViewById<Button>(R.id.addition)
        addition.setOnClickListener{
            val firstNumber = firstInput.text.toString().toInt()
            val secondNumber = secondInput.text.toString().toInt()
            val sum = firstNumber.toDouble() + secondNumber
            val intent = Intent(this, CalculatorResult::class.java)
            intent.putExtra("EXTRA_MESSAGE", sum.toString())
            startActivity(intent)
        }

        val subtraction = findViewById<Button>(R.id.subtraction)
        subtraction.setOnClickListener{
            val firstNumber = firstInput.text.toString().toInt()
            val secondNumber = secondInput.text.toString().toInt()
            val difference = firstNumber.toDouble() - secondNumber
            val intent = Intent(this, CalculatorResult::class.java)
            intent.putExtra("EXTRA_MESSAGE", difference.toString())
            startActivity(intent)
        }

        val multiplication = findViewById<Button>(R.id.multiplication)
        multiplication.setOnClickListener{
            val firstNumber = firstInput.text.toString().toInt()
            val secondNumber = secondInput.text.toString().toInt()
            val product = firstNumber.toDouble() * secondNumber
            val intent = Intent(this, CalculatorResult::class.java)
            intent.putExtra("EXTRA_MESSAGE", product.toString())
            startActivity(intent)
        }

        val division = findViewById<Button>(R.id.division)
        division.setOnClickListener{
            val firstNumber = firstInput.text.toString().toInt()
            val secondNumber = secondInput.text.toString().toInt()
            if (secondNumber != 0) {
                val quotient = "%.3f".format(firstNumber.toDouble()/secondNumber)
                val intent = Intent(this, CalculatorResult::class.java)
                intent.putExtra("EXTRA_MESSAGE", quotient)
                startActivity(intent)
            } else {
                val intent = Intent(this, CalculatorResult::class.java)
                intent.putExtra("EXTRA_MESSAGE", "Cannot divide by 0")
                startActivity(intent)
            }
        }
    }
}