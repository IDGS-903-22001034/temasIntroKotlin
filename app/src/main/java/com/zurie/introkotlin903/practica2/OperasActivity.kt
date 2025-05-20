package com.zurie.introkotlin903.practica2

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
import com.zurie.introkotlin903.R

class OperasActivity : AppCompatActivity() {
    private lateinit var edt1: EditText
    private lateinit var edt2: EditText
    private lateinit var btn1: Button
    private lateinit var tv1: TextView
    private lateinit var Grupo1: RadioGroup
    private lateinit var rSum: RadioButton
    private lateinit var rRes: RadioButton
    private lateinit var rMult: RadioButton
    private lateinit var rDiv: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_operas)
        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)
        Grupo1 = findViewById(R.id.Grupo1)
        rSum = findViewById(R.id.rSum)
        rRes = findViewById(R.id.rRes)
        rMult = findViewById(R.id.rMult)
        rDiv = findViewById(R.id.rDiv)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun calcular(view: android.view.View){

        var num1 = edt1.text.toString().toDouble()
        var num2 = edt2.text.toString().toDouble()
        tv1 = findViewById(R.id.tv1)
        val seleccionado = Grupo1.checkedRadioButtonId

        if (seleccionado == R.id.rSum) {
            val suma = num1 + num2
            val result1="Resultado: $suma"
            tv1.text=result1
        } else if (seleccionado == R.id.rRes) {
            val resta = num1 - num2
            val result2="Resultado: $resta"
            tv1.text=result2
        } else if (seleccionado == R.id.rMult) {
            val mult = num1 * num2
            val result3="Resultado: $mult"
            tv1.text=result3
        }
        else if (seleccionado == R.id.rDiv) {
            val div = num1 / num2
            val result4="Resultado: $div"
            tv1.text=result4
        }



        }
}