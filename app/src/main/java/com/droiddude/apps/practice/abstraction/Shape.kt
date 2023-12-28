package com.droiddude.apps.practice.abstraction

 abstract class Shape(var shapeName : String) {

    constructor(name : String, vararg dimensions : Double) : this(name)

    abstract fun area() : Double
    abstract fun perimeter() : Double

}