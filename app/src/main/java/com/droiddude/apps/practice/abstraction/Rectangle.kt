package com.droiddude.apps.practice.abstraction

class Rectangle (
    val name : String,
    var length : Double,
    var width : Double
    ) : Shape(name) {

    constructor(
        name : String,
        length : Double
    ) : this(name,length, length)

    constructor(
        name : String,
        length : Int,
        width : Int
    ) : this(name,length.toDouble(), width.toDouble())

    init {
        println("A Rectangle is created with length = $length , width = $width")
    }

    override fun area() : Double = this.length * this.width

    override fun perimeter() = 2 * length + 2 * width

    fun isASquare() = length == width

}