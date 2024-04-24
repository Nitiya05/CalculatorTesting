package com.dicoding.junittest

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)

    /**
     * Test case untuk menguji fungsi penambahan pada kalkulator.
     *
     * Langkah-langkah yang dilakukan:
     * 1. Masukkan operand pertama dan kedua.
     * 2. Klik tombol tambah.
     * 3. Klik tombol sama dengan.
     *
     * Hasil yang diharapkan adalah penjumlahan dari kedua operand.
     */
    @Test
    fun testAddition() {
        // Masukkan operand pertama dan kedua
        Espresso.onView(ViewMatchers.withId(R.id.btn1)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.btnAdd)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.btn2)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.btnEqual)).perform(ViewActions.click())

        // Periksa apakah hasilnya benar
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("3")))
    }



}
