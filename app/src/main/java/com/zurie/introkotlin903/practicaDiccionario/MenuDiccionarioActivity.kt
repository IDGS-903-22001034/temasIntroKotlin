package com.zurie.introkotlin903.practicaDiccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.zurie.introkotlin903.R
import com.zurie.introkotlin903.ejemplo1.CinepolisActivity
import com.zurie.introkotlin903.practica1.saludoActivity

class MenuDiccionarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_diccionario)
        val btnCapturar = findViewById<Button>(R.id.btnCapturar) //vinculando los componentes de xml con kotlin
        btnCapturar.setOnClickListener {navegateToCapturar()} // por medio de la funcion navegateToSaludo nos manda a la pantalla de saludo
        val btnBuscar = findViewById<Button>(R.id.btnBuscar) //vinculando los componentes de xml con kotlin
        btnBuscar.setOnClickListener {navegateToBuscar()} // por medio de la funcion navegateToSaludo nos manda a la pantalla de saludo
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navegateToCapturar() {
        val intent = Intent(this, CapturarActivity::class.java)
        startActivity(intent)
    }

    private fun navegateToBuscar() {
        val intent = Intent(this, BuscarActivity::class.java)
        startActivity(intent)
    }
}