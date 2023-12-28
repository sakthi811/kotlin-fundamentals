package com.droiddude.apps.practice.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


/*
In Kotlin coroutines, async and await are used to perform asynchronous operations and await the result of those operations.
They are particularly useful for concurrent programming and parallel execution of tasks.

async:
The async function is a coroutine builder that creates a coroutine and returns an instance of Deferred.
A Deferred is a light-weight non-blocking future that represents the result of a computation that may not have completed yet.

await:
The await() function is used to retrieve the result from a Deferred instance.
It suspends the coroutine until the result is available, and then it returns the result.
 */
fun main() {

    val job1 = GlobalScope.launch(Dispatchers.IO) {
        val time = measureTimeMillis {
            val response1 = async { doNetworkCall1() }
            val response2 = async { doNetworkCall2() }
            println("Response1 is : ${response1.await()}")
            println("Response2 is : ${response2.await()}")
        }
        println("Requests took $time millis")
    }
    runBlocking {
        job1.join()
    }
}