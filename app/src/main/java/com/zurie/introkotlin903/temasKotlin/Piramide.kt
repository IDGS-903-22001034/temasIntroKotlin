package com.zurie.introkotlin903.temasKotlin

/*
    practica2= imprimir una piramide de * segun el numero dado por el usuario
    n=5
    *
    **
    ***
    ****
    *****
    Solo con Do-While
 */


fun main(){

    do{
        println("Dame un valor para tu pirámide")
        var num = readln().toInt()
        var signo = "*"
        var nHorizontal = 1

        do {
            var nVertical = 1
            do {
                print(signo)
                nVertical++
            } while (nVertical <= nHorizontal);
            println()
            nHorizontal++
        }while(nHorizontal <= num);

    }while(num != 0)


}


