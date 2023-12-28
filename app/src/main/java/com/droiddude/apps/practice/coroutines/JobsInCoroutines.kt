package com.droiddude.apps.practice.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
In Kotlin coroutines, a Job is a handle to a coroutine.
It provides methods to control and query the status of the associated coroutine.
When you launch a coroutine, it returns a Job that you can use to manage
the coroutine's lifecycle.

Here are some common operations and concepts related to Job in Kotlin coroutines:

1. Launching a Coroutine:
2. Joining a Coroutine:
3. Cancelling a Coroutine:
4. Exception Handling:
 */
fun main() {
    // 1. Launching a Coroutine:
    // When you launch a coroutine using launch or another coroutine builder,
    // it returns a Job instance.
    val job1 : Job = GlobalScope.launch {
        delay(1000)
        println("Job1 Coroutine completed")
    }
    val job2 : Job = GlobalScope.launch {
        try {
            repeat(1000) { i ->
                println("Job2 Coroutine is Processing value : $i")
                delay(500)
            }
        } finally { // Executes even if the Job is cancelled
            println("Job2 Coroutine completed or cancelled")
        }
    }
    val job3 : Job = GlobalScope.launch {
    //    4. Exception Handling:
    //    When a coroutine throws an exception, it can be handled using the try-catch block,
    //    and the exception can be accessed through the Job's invokeOnCompletion function.
        try {
            delay(1000)
            throw RuntimeException("Simulated Error")
        } catch( e : Exception) {
            println("Caught Exception : $e")
        } finally {
            println("Job3 Finally Block")
        }
    }

    runBlocking {
    //    2. Joining a Coroutine:
    //    The join function is used to wait for the coroutine to complete.
    //    It suspends the calling coroutine until the job is complete.
        job1.join()
        println("Job1 Joined")
        delay(2500)
    //    3. Cancelling a Coroutine:
    //    You can cancel a coroutine by calling the cancel function on its Job.
    //    It's important to note that cancellation is cooperative.
    //    The coroutine code needs to check for cancellation and respond appropriately.
        job2.cancel()
        println("Job2 cancelled")
        job3.join()
        println("Job3 Joined")
    }
}
