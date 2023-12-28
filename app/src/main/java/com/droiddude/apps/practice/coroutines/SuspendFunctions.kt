package com.droiddude.apps.practice.coroutines

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*
In Kotlin coroutines, a 'suspend' function is a function that can be paused and resumed at a later time.
It is a cornerstone of working with coroutines and is used to perform asynchronous or non-blocking operations.
The suspend modifier indicates that a function can suspend the execution of a coroutine,
allowing other coroutines to run in the meantime.
-> The suspend modifier is placed before the fun keyword.
    This indicates that the function can be used within a coroutine.
-> Suspend functions can be called from other suspend functions or within coroutine scopes.
    They can also be called from regular functions using coroutine builders like launch or async.
 */
suspend fun doNetworkCall1() : String {
    delay(3000L)
    return "Response from Network1 call"
}

suspend fun doNetworkCall2() : String {
    delay(3000L)
    return "Response from Network2 call"
}

@Composable
fun SuspendFunctionsScreen() {

    var network1Result by remember { mutableStateOf("TV1") }
    var network2Result by remember { mutableStateOf("TV2") }

    LaunchedEffect(key1 = true ) {
        launch {
            network1Result = doNetworkCall1()
            network2Result = doNetworkCall2()
        }
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(20.dp)) {
        Text(text = network1Result, fontSize = 32.sp, textAlign = TextAlign.Center)
        Text(text = network2Result, fontSize = 32.sp, textAlign = TextAlign.Center)
    }
}
