package com.droiddude.apps.practice.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
'runBlocking' is a coroutine builder in Kotlin that is used to start a new coroutine
and block the current thread until the coroutine completes. It is often used in testing,
main functions, and other scenarios where blocking the thread is acceptable.
Here are some common use cases for runBlocking:

1. Testing Coroutines:
2. Blocking in Main Functions:
3. Checking behavior of coroutines during development
 */
fun main() {
    println("Before RunBlocking")
    runBlocking {
        launch(Dispatchers.IO) {
            delay(3000L)
            println("Finished IO coroutine 1")
        }
        launch(Dispatchers.IO) {
            delay(3000L)
            println("Finished IO coroutine 2")
        }
    }
    println("After RunBlocking")
}