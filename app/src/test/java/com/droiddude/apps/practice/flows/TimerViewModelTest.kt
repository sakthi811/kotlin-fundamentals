package com.droiddude.apps.practice.flows

import androidx.lifecycle.viewmodel.compose.viewModel
import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Assertions.*

import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class TimerViewModelTest {

    private lateinit var viewModel : TimerViewModel
    private lateinit var testDispatchers: TestDispatchers

    @Before
    fun setUp() {
        testDispatchers = TestDispatchers()
        viewModel = TimerViewModel(testDispatchers)
    }

    @Test
    fun `countDownFlow, properly counts down from 5 to 0`() = runBlocking {
        viewModel.countDownValue.test {
            for(i in 5 downTo 0) {
                testDispatchers.testDispatcher.advanceTimeBy(1000L)
                val emission = awaitItem()
                assertThat(emission).isEqualTo(i)
            }
            cancelAndConsumeRemainingEvents()
        }
    }
}