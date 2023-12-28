package com.droiddude.apps.practice.abstraction

fun main() {
//    try {
        val rectangle = Rectangle("Rectangle",24,12)
        val circle = Circle.generateRandomCircle()
        println("Area of Rectangle is ${rectangle.area()}")
        println("Area of Circle is ${circle.area()}")
        println("Among Rectangle and Circle, ${maxArea(rectangle, circle).shapeName} has the Maximum area ")
        val triangle = Triangle("Triangle", 30.0,25.0)
        println("Area of Triangle is ${triangle.area()}")
        println("Among Rectangle,Circle and Triangle, ${maxArea(rectangle, circle,triangle).shapeName} has the Maximum area ")
//    } catch( e : NegativeValueException) {
//        println("Invalid Input : ${e.message}")
//    }

    // Anonymous Class Example
    val a = 3.0
    val b = 2.0
    val height = 4.0
    val parallelogram = object : Shape("Parallelogram", a ,b,height) {
        override fun area(): Double {
            return a * height
        }

        override fun perimeter(): Double {
            return 2 * ( a + b )
        }

        fun isRectangle() : Boolean = height == b
    }
    println("Area Of Parallelogram is : ${parallelogram.area()}")
    println("Perimeter Of Parallelogram is : ${parallelogram.perimeter()}")
    println("Is Parallelogram a rectangle : ${parallelogram.isRectangle()}")
    // Lambda function example(Custom Filter function)
    var shapesList = listOf(rectangle, circle, triangle)
    shapesList = shapesList.customFilter { shape ->
        shape.area() > 500.0
    }.sortedBy { it.area() }
    for(shape in shapesList) println("${shape.shapeName} : Area = ${shape.area()}")
}

// Custom filter function
fun List<Shape>.customFilter(filterFunction :(Shape,String) -> Boolean) : List<Shape> {
    val resultList = mutableListOf<Shape>()
    for(shape in this) {
        if(filterFunction(shape,"")) {
            resultList.add(shape)
        }
    }
    return resultList
}

// custom filter function with Generics
inline fun <T> List<T>.customFilter(filterFunction :(T) -> Boolean) : List<T> {
    val resultList = mutableListOf<T>()
    for(item in this) {
        if(filterFunction(item)) {
            resultList.add(item)
        }
    }
    return resultList
}

fun maxArea(shape1 : Shape, shape2 : Shape) = if(shape1.area() > shape2.area()) shape1 else shape2

// Method Overloading
fun maxArea(shape1: Shape, shape2: Shape, shape3: Shape): Shape {
    val maxShape1Shape2 = maxArea(shape1, shape2)
    return maxArea(maxShape1Shape2, shape3)
}



