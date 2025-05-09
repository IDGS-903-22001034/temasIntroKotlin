package com.zurie.introkotlin903.temasKotlin

fun main(){
    /*
    Range
    1..4=1,2,3,4
    1..<4=1,2,3
    4 downTo 1=4,3,2,1
    1..5 step 2 =1,3,5
    'a'..'z'=a,b,c,d,e,f,g,h,i,j,k,l,m,n,ñ,o,p,k,r,s,t,u,v,w,x,y,z
     */

    for(num in 1..5){
        println(num)
    }

    val frutas = listOf("Manzana", "Pera", "Frambuesa", "Durazno")

    for(fruta in frutas){
        println(fruta)
    }

    val n=10
    var d=0
    while(d<n){
        println(d)
        d++
    }

    /*
    practica2= imprimir una piramide de * segun el numero dado por el usuario
    n=5
    *
    **
    ***
    ****
    *****
    cuando se capture un 0 terminar el programa, utilizando puto do-while
    practica3: La formula general, con valores validos, nos pide los valores hasta que existan valores correctos, sino seguirá pidiendo cada valor (con for o while)
     */
}