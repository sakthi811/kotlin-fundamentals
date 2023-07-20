package com.droiddude.apps.practice.kotlinfundamentals

fun main() {
    var coins = { i : Int ->
        "$i quarters"
    }
    val treatFunction = trickOrTreat(false, coins)
    val trickFunction = trickOrTreat(true,null)
    repeat(4) {
        println(treatFunction())
    }
    println(trickFunction())
}

fun trickOrTreat(isTrick : Boolean, extraTreat : ((Int) -> String)? ) : () -> String {
        if(isTrick) {
            return trick
        } else {
            if(extraTreat != null) { println(extraTreat(5)) }
            return treat
        }

}

val trick = { "Trick function" }

val treat = { "Have a treat" }