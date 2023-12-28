package com.droiddude.apps.practice.flows

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.droiddude.apps.practice.flows.composables.SharedFlowScreen
import com.droiddude.apps.practice.flows.composables.StateFlowScreen
import com.droiddude.apps.practice.flows.composables.TimerScreen
import com.droiddude.apps.practice.ui.theme.TestApplicationTheme

class FlowsDemoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SharedFlowScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TimerScreenPreview() {
    TestApplicationTheme {
        TimerScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun StateFlowScreenPreview() {
    TestApplicationTheme {
        StateFlowScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun SharedFlowScreenPreview() {
    TestApplicationTheme {
        SharedFlowScreen()
    }
}