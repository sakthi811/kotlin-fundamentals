package com.droiddude.apps.practice.abstraction

class Triangle(
    val name : String,
    var base : Double,
    var height : Double
) : Shape(name) {

    init {
        if(base < 0.0 || height < 0.0) throw NegativeValueException()
        println("A Triangle is created with base base $base and height $height")
    }

    fun getName() {
        print(name)
    }

    override fun area(): Double {
        return this.base * this.height / 2
    }

    override fun perimeter(): Double {
        TODO("Not yet implemented")
    }
}