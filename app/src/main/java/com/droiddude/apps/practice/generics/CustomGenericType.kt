package com.droiddude.apps.practice.generics

class CustomGenericType<A : Any,B : Any,C : Any>(
    var first:A,
    var second:B,
    var third:C
) {
    fun printTypes() {
        println("The type of first class is ${first::class}")
        println("The type of second class is ${second::class}")
        println("The type of first class is ${third::class}")
    }
}

class CustomGenerics<A : Any>( val data : A) {
    fun printType() {
        println("The type of class is : ${data::class}")
    }
}

class Search<T : Any> ( val value : T) {
    companion object {
        const val searchEngine : String = "Google"
    }
    fun searchFunction() {
        println("Initiating Search function for ${value::class} data type")
    }
}