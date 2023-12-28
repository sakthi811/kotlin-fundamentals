package com.droiddude.apps.practice.flows.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.droiddude.apps.practice.flows.DefaultDispatcher
import com.droiddude.apps.practice.flows.StateFlowViewModel

@Composable
fun StateFlowScreen() {

    val dispatcher = DefaultDispatcher()
    val stateFlowViewModel = viewModel<StateFlowViewModel>()
    val counterValue = stateFlowViewModel.stateFlow.collectAsState().value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .size(100.dp)
            .background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = counterValue.toString(), fontSize = 72.sp)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = { stateFlowViewModel.decrementCounter() }) {
                Text("-", fontSize = 40.sp)
            }
            Button(onClick = { stateFlowViewModel.incrementCounter() }) {
                Text("+", fontSize = 40.sp)
            }
        }
    }
}