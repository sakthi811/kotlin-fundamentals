package com.droiddude.apps.practice.collections

class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie(
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main() {
    /*
    * The forEach() function executes the function passed as a parameter once for each item in the collection.
    * This works similarly to the repeat() function, or a for loop.
    * */
    cookies.forEach { cookie ->
        println("Menu Item : ${cookie.name}")
    }

    /*
    * The map() function lets you transform a collection into a new collection with the same number of elements.
    * For example, map() could transform a List<Cookie> into a List<String> only containing the cookie's name,
    * provided you tell the map() function how to create a String from each Cookie item.
    * */
    val fullMenu = cookies.map { cookie ->
        "${cookie.name} - $${cookie.price}"
    }
    println("Full menu:")
    fullMenu.forEach { menuItem ->
        println(menuItem)
    }

    /*
    * The filter() function lets you create a subset of a collection.
    * For example, if you had a list of numbers, you could use filter() to create a new list that only contains numbers divisible by 2.
    * */
    val softBakedMenu = cookies.filter { cookie ->
        cookie.softBaked
    }
    println("Soft cookies:")
    softBakedMenu.forEach {
        println("${it.name} - $${it.price}")
    }

    /*
    * The groupBy() function can be used to turn a list into a map, based on a function.
    * Each unique return value of the function becomes a key in the resulting map.
    * */
    val groupedMenu = cookies.groupBy { it.hasFilling }
    val creamFilledItems = groupedMenu[true] ?: listOf()
    val nonCreamyItems = groupedMenu[false] ?: listOf()
    println("Cream Filled cookies:")
    creamFilledItems.forEach {
        println("${it.name} - $${it.price}")
    }
    println("No Cream cookies:")
    nonCreamyItems.forEach {
        println("${it.name} - $${it.price}")
    }

    /*
    * The fold() function is used to generate a single value from a collection.
    * This is most commonly used for things like calculating a total of prices, or summing all the elements in a list to find an average.
    * */
    val totalPrice = cookies.fold(0.0) { total, cookie ->
        total + cookie.price
    }
    println("Total price: $${totalPrice}")

    /*
    * sortedBy() lets you specify a lambda that returns the property you'd like to sort by.
    * For example, if you'd like to sort by price, the lambda would return it.price.
    * */
    val alphabeticalMenu = cookies.sortedBy {
        it.name
    }
    println("Alphabetical menu:")
    alphabeticalMenu.forEach {
        println(it.name)
    }
}