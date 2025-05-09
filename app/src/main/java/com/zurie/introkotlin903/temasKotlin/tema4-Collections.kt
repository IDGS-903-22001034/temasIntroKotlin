package com.zurie.introkotlin903.temasKotlin

fun main(){
    /*
    List - val o contante
    MutableList- Elementos duplicados
    Set - Admite valores unicos y ademas el lis son como las variables
    Mutable
    Map - Son como diccionarios en Pyrthon donde se almacena valores como un json - no mutables.
    MutableMap - mutables

     */


    var lista = listOf<String>("Lunes", "Martes", "Miercoles")
    println(lista) //tamaño
    println(lista.size)
    println(lista.get(0))
    println(lista[1]) //nos da el valor de esa posición
    println(lista.indexOf("Miercoles")) //Da el número que te da ese caracter
    println(lista.first())
    println(lista.last())

    var listaMutable = mutableListOf<String>("Lunes", "Martes", "Miercoles")
    println(listaMutable)
    listaMutable.add("Jueves")
    println(listaMutable)
    listaMutable.removeAt(0)
    println(listaMutable)
    listaMutable.add(0, "Domingo")
    println(listaMutable)
    listaMutable.remove("Miercoles")
}