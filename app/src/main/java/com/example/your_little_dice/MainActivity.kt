package com.example.your_little_dice

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            val currDice = Dice(6)
            rollDice(currDice)
        }
    }

    fun rollDice(dice: Dice) {
        Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
        val resultTextView: TextView = findViewById(R.id.textView)
        val currDice = Dice(6)
        resultTextView.text = dice.roll().toString()
    }
}

class Dice(var sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}