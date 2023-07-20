package com.droiddude.apps.practice.objects

object Student {
    var total : Int = 100
    var marks : Int = 0
}

fun main() {
    Student.marks = 80
    println("Student has obtained ${Student.marks} out of ${Student.total}")
}