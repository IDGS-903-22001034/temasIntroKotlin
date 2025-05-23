package com.zurie.introkotlin903.ejemplo1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.AlertDialog
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.zurie.introkotlin903.R

class CinepolisActivity : AppCompatActivity() {
    private lateinit var edtNombre: EditText
    private lateinit var edtNCompra: EditText
    private lateinit var edtCantBol: EditText
    private lateinit var tvResultado: TextView
    private lateinit var GrupoTarjeta: RadioGroup
    private lateinit var rSi: RadioButton
    private lateinit var rNo: RadioButton
    private lateinit var btnCalcular: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cinepolis)
        edtNombre = findViewById(R.id.edtNombre)
        edtNCompra = findViewById(R.id.edtNCompra)
        edtCantBol = findViewById(R.id.edtCantBol)
        tvResultado = findViewById(R.id.tvResultado)
        GrupoTarjeta = findViewById(R.id.GrupoTarjeta)
        rSi = findViewById(R.id.rSi)
        rNo = findViewById(R.id.rNo)
        btnCalcular = findViewById(R.id.btnCalcular)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun calcular(view: android.view.View){


        val com = edtNCompra.text.toString().toDouble()
        val bol = edtCantBol.text.toString().toDouble()
        tvResultado
        val num=7
        val precio=12
        tvResultado = findViewById(R.id.tvResultado)
        val cineco = GrupoTarjeta.checkedRadioButtonId
        var total=bol*precio

        if (bol>(com*num)) {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder.setTitle("Error")
                .setMessage("La cantidad de boletos por persona se excedió")
                .setPositiveButton("Aceptar", null)
                .show()
            return
        }

        if (bol > 5) {
            total*=0.85
        } else if (bol>2 && bol<=5) {
            total*=0.90
        }

        if (cineco == R.id.rSi) {
            total*=0.90


        }
        tvResultado.text = "$ $total"
    }
}