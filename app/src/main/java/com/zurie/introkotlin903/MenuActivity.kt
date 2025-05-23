package com.zurie.introkotlin903

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.zurie.introkotlin903.ejemplo1.CinepolisActivity
import com.zurie.introkotlin903.practica1.saludoActivity
import com.zurie.introkotlin903.practica2.OperasActivity
import com.zurie.introkotlin903.practica3.Ejemplo3Activity
import com.zurie.introkotlin903.practica4.ArchivosActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        val btnSaludo = findViewById<Button>(R.id.btn1) //vinculando los componentes de xml con kotlin
        btnSaludo.setOnClickListener {navegateToSaludo()} // por medio de la funcion navegateToSaludo nos manda a la pantalla de saludo
        val btnOperaciones = findViewById<Button>(R.id.btnOperaciones) //vinculando los componentes de xml con kotlin
        btnOperaciones.setOnClickListener {navegateToOperaciones()} // por medio de la funcion navegateToSaludo nos manda a la pantalla de saludo
        val btnCinepolis = findViewById<Button>(R.id.btnCinepolis) //vinculando los componentes de xml con kotlin
        btnCinepolis.setOnClickListener {navegateToCinepolis()} // por medio de la funcion navegateToSaludo nos manda a la pantalla de saludo
        val btnEjemplo3 = findViewById<Button>(R.id.btnEjemplo3) //vinculando los componentes de xml con kotlin
        btnEjemplo3.setOnClickListener {navegateToEjemplo3()} // por medio de la funcion navegateToSaludo nos manda a la pantalla de saludo
        val btnArchivos = findViewById<Button>(R.id.btnArchivos) //vinculando los componentes de xml con kotlin
        btnArchivos.setOnClickListener {navegateToArchivos()} // por medio de la funcion navegateToSaludo nos manda a la pantalla de saludo
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navegateToCinepolis() {
        val intent = Intent(this, CinepolisActivity::class.java)
        startActivity(intent)
    }

    //Esta es la función que nos dirige a la ventana de saludo.
    private fun navegateToSaludo() {
        val intent = Intent(this, saludoActivity::class.java)
        startActivity(intent)
    }

    //Esta es la función que nos dirige a la ventana de operaciones.
    private fun navegateToOperaciones() {
        val intent = Intent(this, OperasActivity::class.java)
        startActivity(intent)
    }
    private fun navegateToEjemplo3() {
        val intent = Intent(this, Ejemplo3Activity::class.java)
        startActivity(intent)
    }
    private fun navegateToArchivos() {
        val intent = Intent(this, ArchivosActivity::class.java)
        startActivity(intent)
    }
}