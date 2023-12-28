package com.droiddude.apps.practice.abstraction

import com.droiddude.apps.practice.abstraction.Constants.pi
import kotlin.random.Random

class Circle(
    val name : String,
    val radius : Double
) : Shape(name) {
    init {
        if(radius < 0.0) throw NegativeValueException()
        println("A circle is created with Radius $radius")
    }

    companion object {

        fun generateRandomCircle() : Circle {
            val random = Random.nextDouble(10.0,100.0)
            return Circle(name = "Random Circle",random)
        }
    }

    override fun area() = pi * radius * radius

    override fun perimeter() = 2 * radius * pi

}

