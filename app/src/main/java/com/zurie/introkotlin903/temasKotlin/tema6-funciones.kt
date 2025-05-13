package com.zurie.introkotlin903.temasKotlin


fun saludo(){
    return println("Hola mundo")
}

fun sum(x:Int, y:Int): Int {  // afuera del parentesis colocamos el tipo de dato que se regresa en la función
    return x+y
}

fun sum2(x: Int, y: Int) = x + y  //Función de linea lo de la derecha del parentesis es lo que devuelves

fun main(){
    saludo()
    println("___________________________________________________________________")
    println(sum(2,3))
    println(sum2(2,3))
}

