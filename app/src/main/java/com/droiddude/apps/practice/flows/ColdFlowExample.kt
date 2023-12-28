package com.droiddude.apps.practice.flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
A cold flow produces items only when there is a collector (subscriber)
actively collecting those items. It means that the flow starts emitting
items from the beginning every time a new collector is attached.
 */
fun coldFlowExample() : Flow<Int> = flow {
    for(i in 10 downTo 0) {
        delay(1000)
        emit(i)
    }
}

fun main() {
    runBlocking {
        val coldFlow = coldFlowExample()

        launch {
            coldFlow.collect {
                println("Collector1: $it")
            }
        }

        delay(2000)

        launch {
            coldFlow.collect {
                println("Collector2: $it")
            }
        }
    }
}