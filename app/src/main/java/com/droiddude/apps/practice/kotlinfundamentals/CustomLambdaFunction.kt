package com.droiddude.apps.practice.kotlinfundamentals

import com.droiddude.apps.practice.abstraction.customFilter

fun main() {

    val stringList = listOf("abc","def","ghi","ade")
    val filteredStringList = stringList.customFilter { it.startsWith("a") }
    println("Filtered StringList : $filteredStringList")
    val integerList = (11..20).toList()
    val filteredList = integerList.customFilter { it%2 == 0 }
    println("Filtered List : $filteredList")
    val sum = integerList.customSum { it%2 == 1 }
    println("Custom Sum value is : $sum")
}

// Custom filter function
fun List<Int>.customSum(filterFunction : (Int) -> Boolean) : Int {
    var resultSum = 0
    for(num in this) {
        if(filterFunction(num)) {
            resultSum += num
        }
    }
    return resultSum
}

fun <T : Number> List<T>.customFilter(filterFunction : (T) -> Boolean) : List<T> {
    var resultList = mutableListOf<T>()
    for(item in this) {
        if(filterFunction(item)) {
            resultList.add(item)
        }
    }
    return resultList
}