package com.droiddude.apps.practice.flows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val countDownValue = flow<Int> {
        val startingValue = 10
        var counter = startingValue
        emit(startingValue)
        while( counter > 0) {
            delay(1000L)
            counter--
            emit(counter)
        }
    }

    init {
        collectTimerValue()
    }

    private fun collectTimerValue() {
        viewModelScope.launch {
            countDownValue.collectLatest { time ->
                delay(3000L)
                println("Timer value is $time")
            }
        }
    }
}
