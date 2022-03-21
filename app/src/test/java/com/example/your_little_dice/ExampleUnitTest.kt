package com.example.your_little_dice

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4,2+2)
    }
    @Test
    fun numberGenerator(){
        val dice = Dice(6)
        assertTrue("The value of rollResult was not between 1 and 6",dice.roll()in 1..6)
    }
}