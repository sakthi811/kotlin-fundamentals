package com.droiddude.apps.practice.flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.runBlocking


fun countdownValue() : Flow<Int> = flow {
    for(i in 10 downTo 0) {
        delay(500)
        emit(i)
    }
}

fun foodItemsFlow() : Flow<String> = flow {
    delay(250L)
    emit("Appetizer")
    delay(1000L)
    emit("Main Dish")
    delay(100L)
    emit("Desserts")
}

fun main(){
    runBlocking {
        /*val timerValue = countdownValue()

        timerValue
            .filter { time ->
                time % 2 == 0
            }
            .map { time ->
                time*time
            }
            .onEach { println(it) }
            .collect { time ->
                delay(1000L)
                println("Timer value is $time")
            }
        val count = timerValue.count {
            it % 2 == 0
        }
        println("The count of flow data is $count")
        val reduceResult = timerValue.reduce { accumulator, value ->
            accumulator + value
        }
        println("The count of reduce result is $reduceResult")
        val foldResult = timerValue.fold(100) { accumulator, value ->
            accumulator + value
        }
        println("The count of fold result is $foldResult")
        */
        // Examples for buffer, conflate, collectLatest operators
        val foodItemsFlow = foodItemsFlow()
        foodItemsFlow.onEach {
            println("Delivered $it")
        }
        //.buffer() // The buffer operator creates a separate coroutine during execution for the flow it applies to.
        //.conflate() // The conflate operator always gets the most recent value emitted.
        //.collectLatest { // The crucial difference from collect is that when the original flow emits a new value
        // then the action block for the previous value is cancelled.
        .collect {// collect operator collects each emission and prints one by one
            println("Now Eating $it")
            delay(1500L)
            println("Finished Eating $it")
        }
    }
}