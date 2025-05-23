package com.zurie.introkotlin903.practica4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.zurie.introkotlin903.R
import java.io.FileNotFoundException

class ArchivosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_archivos)
        val btnGuardar = findViewById<Button>(R.id.saveButton)
        val btnLeer = findViewById<Button>(R.id.readButton)
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)
        val outputText = findViewById<TextView>(R.id.outputText)
        val inputText = findViewById<EditText>(R.id.inputText)

        btnGuardar.setOnClickListener{
            val texto = inputText.text.toString()+"\n"
            //val archivo = openFileOutput("datos.txt", MODE_APPEND)
            try{
                openFileOutput("datos.txt", MODE_APPEND).use{  // permite guadar la cantidad de bytes que le pasemos y con el append decimos que es más de una linea
                    it.write(texto.toByteArray())
                }
            }catch(e: Exception){
                e.printStackTrace()
            }
        }
        //btnLeer.setOnClickListener{
            //try {
                //val contenido = openFileInput("datos.txt").bufferedReader().useLines { lines ->
                    //lines.joinToString { "\n" }
                //}
                //outputText.text = contenido
            //}catch (e: FileNotFoundException){
                //outputText.text="Archivo no encontrado."
            //}catch (e:Exception){e.printStackTrace()}
        //}

        btnLeer.setOnClickListener {
            try {
                val contenido = openFileInput("datos.txt").bufferedReader().use { reader ->
                    reader.readText()
                }
                outputText.text = contenido
            } catch (e: FileNotFoundException) {
                outputText.text = "Archivo no encontrado."
            } catch (e: Exception) {
                outputText.text = "Error al leer el archivo: ${e.message}"
                e.printStackTrace()
            }
        }
        btnBorrar.setOnClickListener {
            try {
                deleteFile("datos.txt")
                outputText.text = "Datos borrados"
            } catch(e: Exception) {
                outputText.text = "Error al borrar: ${e.message}"
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}