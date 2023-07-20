package com.droiddude.apps.practice.collections

/*
* An array contains multiple values called elements, or sometimes, items.
* The elements in an array are ordered and are accessed with an index.
* */
fun main() {

    val rockPlanets = arrayOf("Mercury", "Venus", "Earth", "Mars")

    val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")

    val solarSystem = rockPlanets + gasPlanets

    // solarSystem[8] = "Pluto" // If you try to insert an item here, it throws Exception : Index 8 out of bounds for length 8

    solarSystem.forEach {
        println(it)
    }

    val newSolarSystem = arrayOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto")

    println(newSolarSystem[8])
}