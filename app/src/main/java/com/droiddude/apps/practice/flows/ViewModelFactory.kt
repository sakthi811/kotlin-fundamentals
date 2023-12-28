package com.droiddude.apps.practice.flows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyViewModelFactory(private val dispatcher: DispatcherProvider) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TimerViewModel::class.java)) {
            return TimerViewModel(dispatcher) as T
        }
        if(modelClass.isAssignableFrom(SharedFlowViewModel::class.java)) {
            return SharedFlowViewModel(dispatcher) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}