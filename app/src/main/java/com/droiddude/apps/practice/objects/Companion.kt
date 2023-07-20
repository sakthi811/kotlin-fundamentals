package com.droiddude.apps.practice.objects

import com.droiddude.apps.practice.generics.DifficultyLevel
import com.droiddude.apps.practice.generics.Question

class Quiz {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", DifficultyLevel.Medium)
    val question2 = Question<Boolean>("The sky is green. True or false", false, DifficultyLevel.Easy)
    val question3 = Question<Int>("How many days are there between full moons?", 28, DifficultyLevel.Hard)



    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
}

val Quiz.StudentProgress.progressText: String
    get() = "$answered of $total answered"

fun main() {
    println("Quiz Score : ${Quiz.answered} out of ${Quiz.total}")
}
