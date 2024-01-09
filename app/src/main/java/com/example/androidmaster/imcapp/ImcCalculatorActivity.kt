package com.example.androidmaster.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.androidmaster.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false
    private var currentWeight:Int = 75
    private var currentAge:Int = 18
    private var currentHeight:Int = 120

    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var tvWeight:TextView
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var tvAge:TextView
    private lateinit var btnCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponent()
        initListeners()
        initUI()
    }

    private fun initComponent() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        tvAge = findViewById(R.id.tvAge)
        btnCalculate = findViewById(R.id.btnCalculate)

    }

    private fun initListeners() {
        viewMale.setOnClickListener{
            changeGender()
            setGenderColor()}
        viewFemale.setOnClickListener{
            changeGender()
            setGenderColor()}
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##") //para que me limpie los decimales
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }
        btnPlusWeight.setOnClickListener{
            currentWeight++
            setWeight()
        }
        btnSubtractWeight.setOnClickListener{
            currentWeight--
            setWeight()
        }
        btnPlusAge.setOnClickListener{
            currentAge++
            setAge()
        }
        btnSubtractAge.setOnClickListener{
            currentAge--
            setAge()
        }
        btnCalculate.setOnClickListener{
            val result = calculateImc()
            navigateToResult(result)
        }

    }

    private fun navigateToResult(result:Double) {
        val intent = Intent(this, ResultImcActivity::class.java)
        intent.putExtra("result", result)
        startActivity(intent)
    }
    private fun calculateImc():Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble()/100 * currentHeight.toDouble()/100)

        val result = when {
            imc < 18.5 -> "Bajo peso"
            imc < 24.9 -> "Normal"
            imc < 29.9 -> "Sobrepeso"
            else -> "Obesidad"
        }
        Log.i("IMC", "El resultado es $result")
        return df.format(imc).toDouble()
    }
    private fun setAge() {
        tvAge.text = "$currentAge Años"
    }
    private fun setWeight() {
        tvWeight.text = "$currentWeight kg"
    }
    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }
    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent:Boolean):Int {

        var colorReference = if(isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference) //me devuelve un entero
    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }
}