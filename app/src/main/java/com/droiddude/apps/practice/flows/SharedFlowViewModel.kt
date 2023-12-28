package com.droiddude.apps.practice.flows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class SharedFlowViewModel(
    val dispatcher: DispatcherProvider
) : ViewModel() {

    private val _sharedFlow = MutableSharedFlow<Int>(0)
    val sharedFlow = _sharedFlow.asSharedFlow()

    init {
        viewModelScope.launch(dispatcher.main) {
            sharedFlow.collect {
                println("Flow 1 : Collected value is : $it")
            }
        }
        viewModelScope.launch(dispatcher.main) {
            sharedFlow.collect {
                println("Flow 2 : Collected value is : $it")
            }
        }
    }

    fun squareNumber(n : Int) {
        viewModelScope.launch(dispatcher.main) {
            _sharedFlow.emit(n*n)
        }
    }
}