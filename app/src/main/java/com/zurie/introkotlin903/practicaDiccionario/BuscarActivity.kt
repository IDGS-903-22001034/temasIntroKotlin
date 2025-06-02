package com.zurie.introkotlin903.practicaDiccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.app.AlertDialog
import com.zurie.introkotlin903.R


class BuscarActivity : AppCompatActivity() {
    private lateinit var edtPalabraBuscar: EditText
    private lateinit var tvAviso: TextView
    private lateinit var tvResultado: TextView
    private lateinit var GrupoLengua: RadioGroup
    private lateinit var rEspanol: RadioButton
    private lateinit var rIngles: RadioButton
    private lateinit var btnBuscar: Button
    private lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buscar)
        edtPalabraBuscar = findViewById(R.id.edtPalabraBuscar)
        tvAviso = findViewById(R.id.tvAviso)
        tvResultado = findViewById(R.id.tvResultado)
        GrupoLengua = findViewById(R.id.GrupoLengua)
        rEspanol = findViewById(R.id.rEspanol)
        rIngles = findViewById(R.id.rIngles)
        btnBuscar = findViewById(R.id.btnBuscar)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar) //vinculando los componentes de xml con kotlin
        btnRegresar.setOnClickListener {navegateToMenuDiccionario()} // por medio de la funcion navegateToSaludo nos manda a la pantalla de saludo
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun buscar(view: android.view.View) {
        val palabraBuscada = edtPalabraBuscar.text.toString().trim()

        if (palabraBuscada.isEmpty()) {
            AlertDialog.Builder(this)
                .setTitle("Advertencia")
                .setMessage("Por favor, introduce una palabra")
                .setPositiveButton("Aceptar", null)
                .show()
            tvAviso.text = ""
            tvResultado.text = ""
            return
        }

        try {
            openFileInput("diccionario.txt").use { archivo ->
                val contenido = archivo.bufferedReader().use { it.readText() }
                val lineas = contenido.split("\n")

                var palabraEncontrada = false
                var traduccion = ""

                for (linea in lineas) {
                    if (linea.contains(",")) {
                        val (espanol, ingles) = linea.split(",")

                        if (espanol.equals(palabraBuscada, ignoreCase = true)) {
                            palabraEncontrada = true
                            traduccion = ingles
                            break
                        } else if (ingles.equals(palabraBuscada, ignoreCase = true)) {
                            palabraEncontrada = true
                            traduccion = espanol
                            break
                        }
                    }
                }

                if (palabraEncontrada) {
                    tvAviso.text = "Palabra encontrada"
                    tvResultado.text = traduccion

                } else {
                    tvAviso.text = "Palabra no encontrada"
                    tvResultado.text = ""
                }
            }
        } catch (e: Exception) {
            // Si el archivo no existe
            tvAviso.text = "Diccionario vacío"
            tvResultado.text = ""

            AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage("El diccionario está vacío o no existe")
                .setPositiveButton("Aceptar", null)
                .show()

            e.printStackTrace()
        }
    }
    fun navegateToMenuDiccionario(){
        val intent = Intent(this, MenuDiccionarioActivity::class.java)
        startActivity(intent)
    }
}