package com.droiddude.apps.practice.coroutines

import android.util.Log
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/*
In Kotlin coroutines, a CoroutineContext is a context that defines various elements of coroutine execution,
such as the coroutine dispatcher and other context elements. The CoroutineContext is an interface,
and it's commonly used to specify the context in which a coroutine runs.

Here are some important aspects of coroutine contexts in Kotlin:

1. Coroutine Dispatcher:
A CoroutineDispatcher is a specific implementation of CoroutineContext that determines the thread or threads
a coroutine uses for its execution. Common dispatchers include:

Dispatchers.Default: Optimized for CPU-intensive work. Uses a pool of threads.

Dispatchers.IO: Optimized for I/O-intensive work. Uses a shared pool of threads.

Dispatchers.Main: For Android applications, this is the main UI thread. It's available when using the kotlinx-coroutines-android library.

Dispatchers.Unconfined: Runs the coroutine in the caller thread until the first suspension point.

2. CoroutineScope:
CoroutineScope is another important interface that extends CoroutineContext.
It is used to define a scope for coroutines. A coroutine scope is responsible for managing the lifecycle of coroutines.
When you launch a coroutine using launch or other coroutine builders, it is typically associated with a specific CoroutineScope.

3. Job:
A Job is a component of the CoroutineContext that represents the lifecycle of a coroutine.
It can be used to cancel or join coroutines. When you launch a coroutine using launch, it returns a Job instance.

4. Combining Contexts:
You can combine multiple contexts using the + operator. For example, if you want to use a specific dispatcher and a custom job:
=========================================================================================
| val customDispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()    |
| val customJob = Job()                                                                 |
| val combinedContext: CoroutineContext = customDispatcher + customJob                  |
=========================================================================================

5. GlobalScope:
GlobalScope is a predefined coroutine scope that is not bound to any specific lifecycle.
It's often used for top-level coroutines, but it's generally recommended to use a more localized CoroutineScope
associated with a specific component.
 */
@Composable
fun CoroutineContextsDemo() {
    val TAG = "CoroutineContexts"
    var network1Result by remember { mutableStateOf("TV1") }
    var network2Result by remember { mutableStateOf("TV2") }

    LaunchedEffect(key1 = true) {
        launch(Dispatchers.IO) {// IO Dispatcher for Network call
            Log.d(TAG,"Started Network call in Thread ${Thread.currentThread().name}")
            val result1 = doNetworkCall1()
            val result2 = doNetworkCall2()
            withContext(Dispatchers.Main) {// Switching Contexts
                Log.d(TAG,"Setting UI States in Thread ${Thread.currentThread().name}")
                network1Result = result1
                network2Result = result2
            }
        }
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)) {
        Text(text = network1Result, fontSize = 32.sp, textAlign = TextAlign.Center)
        Text(text = network2Result, fontSize = 32.sp, textAlign = TextAlign.Center)
    }
}