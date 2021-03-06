package com.example.travelcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View) {
        when (v.id) {
            R.id.buttonCalculate -> handleCalculate()
            R.id.buttonClean -> cleanText()
            else -> {
                println("Ops...")
                println(v.id)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)
        buttonClean.setOnClickListener(this)
    }

    private fun cleanText() {
        editDistance.text.clear()
        editPrice.text.clear()
        editAutonomy.text.clear()
        textResult.text = getString(R.string.gasto_total)
    }

    private fun handleCalculate() = if (isValid()) {
        try {
            val distance = editDistance.text.toString().toFloat()
            val price = editPrice.text.toString().toFloat()
            val autonomy = editAutonomy.text.toString().toFloat()

            val result = ((distance * price) / autonomy)
            textResult.setText("Total: R$ $result")

        } catch (nfe: NumberFormatException) {
            toastMsg()
        }

    } else {
        toastMsg()
    }

    private fun toastMsg() {
        Toast.makeText(this, getString(R.string.valores_validos), Toast.LENGTH_LONG).show()
    }

    private fun isValid(): Boolean {
        return editDistance.text.toString() != ""
                && editPrice.text.toString() != ""
                && editAutonomy.text.toString() != ""
                && editAutonomy.text.toString() != "0"
    }
}
