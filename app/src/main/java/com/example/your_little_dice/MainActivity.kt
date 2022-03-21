package com.example.your_little_dice

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.your_little_dice.databinding.ActivityMainBinding
private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    fun logging(){
        Log.e(TAG, "ERROR: a serious error like an app crash")
        Log.w(TAG, "WARN: warns about the potential for serious errors")
        Log.i(TAG, "INFO: reporting technical information, such as an operation succeeding")
        Log.d(TAG, "DEBUG: reporting technical information useful for debugging")
        Log.v(TAG, "VERBOSE: more verbose than DEBUG logs")
    }
    var flagForToast = false
    //binding for convenient coding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        logging()
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //button on click listener
        binding.butRoll.setOnClickListener {
            val currDice = Dice(6)
            rollDice(currDice)
        }
        var startDice = Dice(6)
        rollDice(startDice)
        flagForToast = true
    }
    //method for rolling a dice in activity
    private fun rollDice(dice: Dice) {
        //show toast message
        if (flagForToast)Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
        //create and roll a dice
        val currDice = Dice(6)
        val currRoll = currDice.roll()
        //change contDescription and imgResource
        binding.ivDice.contentDescription = currRoll.toString()
        binding.ivDice.setImageResource(when(currRoll) {
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        })
    }
}
//dice class with roll function
class Dice(var sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}