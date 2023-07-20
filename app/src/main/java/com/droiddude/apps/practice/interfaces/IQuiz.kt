package com.droiddude.apps.practice.interfaces

class Quiz : ProgressPrintable {

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

    override val progressText: String
        get() = "$answered of $total answered"

    override fun printProgressBar() {
        repeat(answered) { print("▓") }
        repeat(total - answered) { print("▒") }
        println()
        println(progressText)
    }
}

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

fun main() {
    Quiz().printProgressBar()
}