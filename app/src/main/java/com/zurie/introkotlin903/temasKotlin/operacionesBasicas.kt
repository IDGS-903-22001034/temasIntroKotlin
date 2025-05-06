package com.zurie.introkotlin903.temasKotlin

fun main(){

    do{
        println("¿Qué operación quieres hacer? \n1:suma\n2:resta \n3:multiplicacion \n4:division\n5:Salir")
        val opcion = readln().toInt()
        if(opcion == 1){
            println("Ingresa el primer valor")
            val num1 = readln().toDouble()
            println("Ingresa el segundo valor")
            val num2 = readln().toDouble()
            val suma = num1 + num2
            println("La suma de $num1 y $num2 es $suma")
        }
        else if(opcion == 2){
            println("Ingresa el primer valor")
            val num1 = readln().toDouble()
            println("Ingresa el segundo valor")
            val num2 = readln().toDouble()
            val resta = num1 - num2
            println("La resta de $num1 y $num2 es $resta")
        }
        else if(opcion == 3){
            println("Ingresa el primer valor")
            val num1 = readln().toDouble()
            println("Ingresa el segundo valor")
            val num2 = readln().toDouble()
            val mult = num1 * num2
            println("La mult de $num1 y $num2 es $mult")
        }
        else if(opcion == 4){
            println("Ingresa el primer valor")
            val num1 = readln().toDouble()
            println("Ingresa el segundo valor")
            val num2 = readln().toDouble()
            val div = num1 / num2
            println("La div de $num1 y $num2 es $div")
        }
        else{
            println("No existe esa operación")
        }
    }while(opcion !=5)
}