package com.dicoding.junittest

import org.junit.Assert.assertEquals
import org.junit.Test

class CalculatorUtilUnitTest {

    /**
     * Test case untuk menguji penambahan.
     *
     * Dalam test case ini, kita ingin memastikan bahwa penambahan berfungsi dengan benar.
     */
    @Test
    fun testCalculatorUtil_Addition() {
        val result = CalculatorUtil.calculate("1+2")
        assertEquals(3, result)
    }

    /**
     * Test case untuk menguji pengurangan.
     *
     * Dalam test case ini, kita ingin memastikan bahwa pengurangan berfungsi dengan benar.
     */
    @Test
    fun testCalculatorUtil_Subtraction() {
        val result = CalculatorUtil.calculate("5-3")
        assertEquals(2, result)
    }

    /**
     * Test case untuk menguji perkalian.
     *
     * Dalam test case ini, kita ingin memastikan bahwa perkalian berfungsi dengan benar.
     */
    @Test
    fun testCalculatorUtil_Multiplication() {
        val result = CalculatorUtil.calculate("2*4")
        assertEquals(8, result)
    }

    /**
     * Test case untuk menguji penambahan dan perkalian sekaligus.
     *
     * Dalam test case ini, kita ingin memastikan bahwa penambahan dan perkalian berfungsi dengan benar.
     */
    @Test
    fun testCalculatorUtil_MixedOperations() {
        val result = CalculatorUtil.calculate("2+3*4")
        assertEquals(14, result)
    }

}
