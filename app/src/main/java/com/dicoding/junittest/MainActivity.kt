// MainActivity.kt
package com.dicoding.junittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/**
 * Aktivitas utama yang mengatur antarmuka pengguna untuk kalkulator.
 */
class MainActivity : AppCompatActivity() {
    private var currentInput = "" // Variabel untuk menyimpan input pengguna
    private lateinit var resultTextView: TextView // TextView untuk menampilkan hasil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView) // Inisialisasi resultTextView

        // Set OnClickListener untuk semua tombol
        val buttons = arrayOf(
            findViewById<Button>(R.id.btn0), findViewById<Button>(R.id.btn1),
            findViewById<Button>(R.id.btn2), findViewById<Button>(R.id.btn3),
            findViewById<Button>(R.id.btn4), findViewById<Button>(R.id.btn5),
            findViewById<Button>(R.id.btn6), findViewById<Button>(R.id.btn7),
            findViewById<Button>(R.id.btn8), findViewById<Button>(R.id.btn9),
            findViewById<Button>(R.id.btnAdd), findViewById<Button>(R.id.btnSubtract),
            findViewById<Button>(R.id.btnMultiply), findViewById<Button>(R.id.btnDivide),
            findViewById<Button>(R.id.btnClear), findViewById<Button>(R.id.btnEqual)
        )

        buttons.forEach { button ->
            button.setOnClickListener {
                onButtonClick(button)
            }
        }
    }

    /**
     * Metode untuk menangani klik tombol.
     *
     * @param button tombol yang diklik.
     */
    private fun onButtonClick(button: Button) {
        // Menghandle klik tombol
        val buttonText = button.text.toString()

        when {
            buttonText == "C" -> {
                // Menghapus input
                currentInput = ""
                resultTextView.text = "0"
            }
            buttonText == "=" -> {
                // Menghitung hasil
                val result = CalculatorUtil.calculate(currentInput)
                resultTextView.text = result.toString()
            }
            else -> {
                // Menambahkan digit atau operator ke input
                currentInput += buttonText
                resultTextView.text = currentInput
            }
        }
    }
}

