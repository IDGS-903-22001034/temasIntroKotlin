package com.zurie.introkotlin903.temasKotlin
import kotlin.math.sqrt
fun main(){

    do{
        println("Dame el valor de A")
        var a = readln().toDouble()
        println("Dame el valor de B")
        var b = readln().toDouble()
        println("Dame el valor de C")
        var c = readln().toDouble()

       var dis = (b*b-4*a*c)

        if(a==0.0 || dis<0){
            println("No son valores correctos")
        }
        else{
            val xUno=(-b + sqrt(dis))/(2*a)
            val xDos=(-b - sqrt(dis))/(2*a)
            println("X1 = $xUno")
            println("X2 = $xDos")
            break
        }

    }while(true)


}