package com.droiddude.apps.practice.flows

import androidx.lifecycle.viewmodel.compose.viewModel
import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class SharedFlowViewModelTest {
    private lateinit var viewModel : SharedFlowViewModel
    private lateinit var testDispatchers: TestDispatchers

    @Before
    fun setUp() {
        testDispatchers = TestDispatchers()
        viewModel = SharedFlowViewModel(testDispatchers)
    }

    @Test
    fun `squareNumber, properly squared`() = runBlocking {
        val job = launch {
            viewModel.sharedFlow.test {
                val emission = awaitItem()
                assertThat(emission).isEqualTo(9)
                cancelAndConsumeRemainingEvents()
            }
        }
        viewModel.squareNumber(3)
        job.join()
        job.cancel()
    }
}