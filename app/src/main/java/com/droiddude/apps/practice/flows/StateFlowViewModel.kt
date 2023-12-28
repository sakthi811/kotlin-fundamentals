package com.droiddude.apps.practice.flows

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class StateFlowViewModel() : ViewModel() {

    private val _stateFlow = MutableStateFlow(0)
    val stateFlow = _stateFlow.asStateFlow()

    fun incrementCounter() {
        _stateFlow.value += 1
    }

    fun decrementCounter() {
        _stateFlow.value -= 1
    }
}