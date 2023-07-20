package com.droiddude.apps.practice.scopefunctions

import com.droiddude.apps.practice.generics.DifficultyLevel
import com.droiddude.apps.practice.generics.Question

class SFQuiz {

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

    fun printQuiz() {
        val question1 = Question<String>("Quoth the raven ___", "nevermore", DifficultyLevel.Medium)
        val question2 = Question<Boolean>("The sky is green. True or false", false, DifficultyLevel.Easy)
        val question3 = Question<Int>("How many days are there between full moons?", 28 , DifficultyLevel.Hard)
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }

}

val SFQuiz.StudentProgress.progressText: String
    get() = "$answered of $total answered"

fun SFQuiz.StudentProgress.printProgressBar() {
    repeat(answered) { print("▓") }
    repeat(total - answered) { print("▒") }
    println()
    println(progressText)
}


fun main() {
    SFQuiz().apply {
        printQuiz()
    }
}