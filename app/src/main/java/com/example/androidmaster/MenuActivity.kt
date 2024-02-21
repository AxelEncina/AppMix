package com.example.androidmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidmaster.todoapp.TodoActivity
import com.example.androidmaster.firstapp.FirstAppActivity
import com.example.androidmaster.imcapp.ImcCalculatorActivity
import com.example.androidmaster.settings.SettingsActivity
import com.example.androidmaster.superheroapp.SuperHeroListActivity


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        val btnToDo = findViewById<Button>(R.id.btnTODO)
        val btnSettings = findViewById<Button>(R.id.btnSettings)
        btnSettings.setOnClickListener { navigateToSettings() }
        btnSaludApp.setOnClickListener { navigateToSaludApp() }
        btnIMCApp.setOnClickListener { navigateToIMCApp() }
        btnToDo.setOnClickListener { navigateToToDoApp() }
        val btnSuperHeroList = findViewById<Button>(R.id.btnSuperhero)
        btnSuperHeroList.setOnClickListener { navigateToSuperHeroList() }
    }

    private fun navigateToSettings() {
        val intent = Intent(this, SettingsActivity::class.java)
        //intent.putExtra("name", "Android Master")
        startActivity(intent)
    }

    private fun navigateToToDoApp() {
        val intent = Intent(this, TodoActivity::class.java)
        //intent.putExtra("name", "Android Master")
        startActivity(intent)
    }
    private fun navigateToSaludApp() {
        val intent = Intent(this, FirstAppActivity::class.java)
        //intent.putExtra("name", "Android Master")
        startActivity(intent)
    }

    private fun navigateToIMCApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        //intent.putExtra("name", "Android Master")
        startActivity(intent)
    }

    private fun navigateToSuperHeroList() {
        val intent = Intent(this, SuperHeroListActivity::class.java)
        //intent.putExtra("name", "Android Master")
        startActivity(intent)
    }

}