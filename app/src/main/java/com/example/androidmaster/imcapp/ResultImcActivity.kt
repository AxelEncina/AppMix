package com.example.androidmaster.imcapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.example.androidmaster.R
import java.text.DecimalFormat

class ResultImcActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvDescription: TextView
    private lateinit var tvIMC: TextView
    private lateinit var btnReCalculate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imc)
        val result = intent.extras?.getDouble("result") ?: -1.0
        initComponent()
        initUI(result)
        initListeners()
    }

    private fun initListeners() {
        btnReCalculate.setOnClickListener {
            onBackPressed()
        }
    }
    private fun initUI(result: Double) {
        tvResult.text = "Tu Índice de Masa Corporal es: "
        //val df = DecimalFormat("#.##")
        tvIMC.text = result.toString()
        when (result) {
            in 0.00..18.50 -> {
                tvDescription.text = "Bajo peso" //para hacerlo no hardcodeado se puede usar getString(R.string.bajo_peso) y en el strings.xml poner <string name="bajo_peso">Bajo peso</string>
                tvDescription.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
            }
            in 18.51..24.90 -> {
                tvDescription.text = "Normal"
                tvDescription.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
            }
            in 24.91..29.90 -> {
                tvDescription.text = "Sobrepeso"
                tvDescription.setTextColor(ContextCompat.getColor(this, R.color.sobrepeso))
            }
            in 29.91..100.00 -> {
                tvDescription.text = "Obesidad"
                tvDescription.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
            }
            else -> {
                tvDescription.text = "ERROR"
                tvDescription.setTextColor(ContextCompat.getColor(this, R.color.obesidad)) //porque es rojo
            }
        }

    }
    private fun initComponent() {
        tvResult = findViewById(R.id.tvResult)
        tvDescription = findViewById(R.id.tvDescription)
        tvIMC = findViewById(R.id.tvIMC)
        btnReCalculate = findViewById(R.id.btnReCalculate)
    }
}