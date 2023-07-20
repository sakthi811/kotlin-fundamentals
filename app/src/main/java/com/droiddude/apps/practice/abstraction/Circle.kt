package com.droiddude.apps.practice.abstraction

import com.droiddude.apps.practice.abstraction.Constants.pi
import kotlin.random.Random

data class Circle(
    val name : String,
    val radius : Double
) : Shape(name) {
    init {
        if(radius < 0.0) throw NegativeValueException()
        println("A circle is created with Radius $radius")
    }

    companion object {

        fun generateRandomCircle() : Circle {
            val radius = Random.nextDouble(1.0 , 20.0)
            return Circle("circle$radius",radius)
        }
    }

    override fun area() = pi * radius * radius

    override fun perimeter(): Double {
        TODO("Not yet implemented")
    }
}

class NegativeValueException : Exception("You cannot create a circle with a negative Radius. Kindly enter a positive value")