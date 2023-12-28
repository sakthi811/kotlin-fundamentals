package com.droiddude.apps.practice.flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() {
    val flow1 = (1..5).asFlow()
    runBlocking {
        // FlatMapConcat : Returns flow on each emission, concatenating values from multiple flows
        println("FlatMapConcat Example:")
        flow1.flatMapConcat { value ->
            flow {
                emit(value + 1)
                emit(value + 2)
                delay(1000L)
            }
        }.collect { value ->
            println("The value is $value")
        }
        // FlatmapMerge : Returns a flow with values from multiple flows at once
        /*println("FlatMapMerge Example:")
        flow1.flatMapMerge { value ->
            flow {
                delay(2000L)
                emit(value + 1)
                emit(value + 2)
            }
        }.collect { value ->
            println("The value is $value")
        }*/
        // FlatMapLatest : Returns a flow with Latest values
        /*println("FlatMapLatest Example:")
        flow1.flatMapLatest { value ->
            flow {
                delay(2000L)
                emit(value + 1)
                emit(value + 2)
            }
        }.collect { value ->
            println("The value is $value")
        }*/
    }
}