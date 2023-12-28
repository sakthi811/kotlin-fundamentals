package com.droiddude.apps.practice.flows.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.droiddude.apps.practice.flows.DefaultDispatcher
import com.droiddude.apps.practice.flows.MyViewModelFactory
import com.droiddude.apps.practice.flows.TimerViewModel

@Composable
fun TimerScreen() {

    val dispatcher = DefaultDispatcher()
    val viewModel = viewModel<TimerViewModel>(factory = MyViewModelFactory(dispatcher))
    val timer = viewModel.countDownValue.collectAsState(initial = 10).value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .size(100.dp)
            .background(Color.Cyan),
        contentAlignment = Alignment.Center
    ) {
        Text(text = timer.toString(), fontSize = 72.sp)
    }
}