package com.zurie.introkotlin903.temasKotlin

fun main(){
    println("Ingrese el sueldo del empleado:")
    val sueldo = readln().toDouble() //readln es para leer algun valor puesto por el usuario
    if(sueldo > 3000){
        println("Deben pagar impuestos")
    }else{
        println("No deben pagar impuestos")
    }
}