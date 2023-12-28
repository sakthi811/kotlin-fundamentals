package com.droiddude.apps.practice.generics

data class Question<T>(
    val questionText : String,
    val answer : T?,
    val difficulty : DifficultyLevel
) {
    fun print() {
        println("Question : $questionText")
        println("Answer : ${answer?.toString() ?: ""}")
        println("Difficulty Level : $difficulty")
    }
}

enum class DifficultyLevel {
    Easy, Medium, Hard
}

fun main() {

    val question1 = Question<String>("Quoth the raven ___", "nevermore", DifficultyLevel.Medium)
    val question2 = Question<Boolean>("The sky is green. True or false", false, DifficultyLevel.Easy)
    val question3 = Question<Int>("How many days are there between full moons?", null , DifficultyLevel.Hard)

//    println(question1.toString())
//    question2.print()
//    question3.print()

    val genericType = CustomTriple(10,"Sakthi",false)
    genericType.printTypes()
}
