package com.droiddude.apps.practice.collections

/*
* A list is an ordered, resizable collection, typically implemented as a resizable array.
* When the array is filled to capacity and you try to insert a new element, the array is copied to a new bigger array.
 */

fun main() {

    val solarSystem = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    println("There are ${solarSystem.size} planets in Solar System")

    println(solarSystem[2])

    println(solarSystem.get(3))

    println(solarSystem.indexOf("Earth"))

    println(solarSystem.indexOf("Pluto"))

    for(planet in solarSystem) {
        println(planet)
    }

    // With a list(mutable), you can also insert new elements between other elements at a specific index.
    val newSolarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    newSolarSystem.add("Pluto")

    newSolarSystem.add(3, "Theia")

    newSolarSystem[3] = "Future Moon"

    newSolarSystem.removeAt(9)

    println("New Solar System : ")
    for(planet in newSolarSystem) {
        println(planet)
    }

    newSolarSystem.remove("Future Moon")

    println(newSolarSystem.contains("Pluto"))

    println("Future Moon" in newSolarSystem)
}