package com.droiddude.apps.practice.flows.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.droiddude.apps.practice.flows.DefaultDispatcher
import com.droiddude.apps.practice.flows.MyViewModelFactory
import com.droiddude.apps.practice.flows.SharedFlowViewModel
import com.droiddude.apps.practice.flows.StateFlowViewModel
import com.droiddude.apps.practice.flows.TimerViewModel

@Composable
fun SharedFlowScreen() {
    val dispatcher = DefaultDispatcher()
    val sharedFlowViewModel = viewModel<SharedFlowViewModel>(factory = MyViewModelFactory(dispatcher))
    val squareValue = sharedFlowViewModel.sharedFlow.collectAsState(initial = 0)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .size(100.dp)
            .background(Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = squareValue.value.toString(), fontSize = 72.sp)
        Button(onClick = { sharedFlowViewModel.squareNumber(5) }) {
            Text(text = "Calculate Square")
        }
    }
}

