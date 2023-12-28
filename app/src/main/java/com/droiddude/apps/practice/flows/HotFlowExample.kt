package com.droiddude.apps.practice.flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
A hot flow emits items regardless of whether there are collectors or not.
It starts emitting items as soon as it is created, and collectors can join
the flow at any point to start receiving items emitted after they subscribe.
 */
fun hotFlowExample() : Flow<Int> = callbackFlow {
    for( i in 1..3) {
        delay(1000)
        send(i)
    }
    close()
}

fun main() {
    runBlocking {
        val hotFlow = hotFlowExample()

        launch {
            hotFlow.collect {
                println("Collector1: $it")
            }
        }

        delay(2000)

        launch {
            hotFlow.collect {
                println("Collector2: $it")
            }
        }
    }
}