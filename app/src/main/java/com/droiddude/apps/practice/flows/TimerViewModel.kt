package com.droiddude.apps.practice.flows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class TimerViewModel(
    private val dispatcher: DispatcherProvider
) : ViewModel() {

    val countDownValue = flow<Int> {
        val startingValue = 5
        var counter = startingValue
        emit(startingValue)
        while( counter > 0) {
            delay(1000L)
            counter--
            emit(counter)
        }
    }.flowOn(dispatcher.main)

    init {
        collectTimerValue()
    }

    private fun collectTimerValue() {
        viewModelScope.launch(dispatcher.main) {
            // Collect operators example
            countDownValue
                .collect { time ->
                    delay(1000L)
                    println("Timer value is $time")
                }
        }
    }
}
