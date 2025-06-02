package com.zurie.introkotlin903.practicaDiccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.zurie.introkotlin903.R

class CapturarActivity : AppCompatActivity() {

    private lateinit var edtEspanol: EditText
    private lateinit var edtIngles: EditText
    private lateinit var btnGuardar: Button
    private lateinit var btnRegresar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capturar)
        edtEspanol = findViewById(R.id.edtEspanol)
        edtIngles = findViewById(R.id.edtIngles)
        btnGuardar = findViewById(R.id.btnGuardar)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar) //vinculando los componentes de xml con kotlin
        btnRegresar.setOnClickListener {navegateToMenuDiccionario()} // por medio de la funcion navegateToSaludo nos manda a la pantalla de saludo
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun capturar(view: android.view.View){
        val palabraEspanol = edtEspanol.text.toString().trim()
        val palabraIngles = edtIngles.text.toString().trim()

        try {
            openFileOutput("diccionario.txt", MODE_APPEND).use { archivo ->
                archivo.write("$palabraEspanol,$palabraIngles\n".toByteArray())
            }

            AlertDialog.Builder(this)
                .setTitle("Éxito")
                .setMessage("Palabras guardadas correctamente")
                .setPositiveButton("Aceptar") { dialog, which ->
                    edtEspanol.text.clear()
                    edtIngles.text.clear()
                }
                .show()

        } catch (e: Exception) {
            e.printStackTrace()
            AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage("Error al guardar las palabras")
                .setPositiveButton("Aceptar", null)
                .show()
        }
    }

    fun navegateToMenuDiccionario(){
        val intent = Intent(this, MenuDiccionarioActivity::class.java)
        startActivity(intent)
    }
}