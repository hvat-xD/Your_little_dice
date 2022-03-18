package com.example.your_little_dice

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.your_little_dice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //val rollButton: Button = findViewById(R.id.button)
        binding.button.setOnClickListener {
            val currDice = Dice(6)
            rollDice(currDice)
        }
    }

    fun rollDice(dice: Dice) {
        Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
        val currDice = Dice(6)
        val currRoll = currDice.roll()
        when(currRoll) {
            1->binding.imageView.setImageResource(R.drawable.dice_1)
            2->binding.imageView.setImageResource(R.drawable.dice_2)
            3->binding.imageView.setImageResource(R.drawable.dice_3)
            4->binding.imageView.setImageResource(R.drawable.dice_4)
            5->binding.imageView.setImageResource(R.drawable.dice_5)
            6->binding.imageView.setImageResource(R.drawable.dice_6)
        }
    }
}

class Dice(var sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}