package com.droiddude.apps.practice.collections

/*
* A Map is a collection consisting of keys and values.
* It's called a map because unique keys are mapped to other values.
* A key and its accompanying value are often called a key-value pair.
* */

fun main() {

    val solarSystem = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )

    println(solarSystem.size)

    solarSystem["Pluto"] = 5

    println(solarSystem.size)

    println(solarSystem["Pluto"])

    println(solarSystem.get("Theia"))

    solarSystem.remove("Pluto")

    solarSystem["Jupiter"] = 78
    
    println(solarSystem["Jupiter"])

    solarSystem.forEach { planet, moon ->
        println("Planet $planet has $moon moons")
    }

}