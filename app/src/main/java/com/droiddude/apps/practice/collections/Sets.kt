package com.droiddude.apps.practice.collections

/*
* A set is a collection that does not have a specific order and does not allow duplicate values.
* Sets have two important properties:
* 1. Searching for a specific element in a set is fast—compared with lists—especially for large collections.
* 2. Sets tend to use more memory than lists for the same amount of data, since more array indices are often needed than the data in the set.
* */

fun main() {

    val solarSystem = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    println("There are ${solarSystem.size} planets in Solar System")

    solarSystem.add("Pluto")

    println(solarSystem.size)

    println(solarSystem.contains("Pluto"))

    solarSystem.add("Pluto")

    println(solarSystem.size)

    solarSystem.remove("Pluto")

    println(solarSystem.size)

    println(solarSystem.contains("Pluto"))
}