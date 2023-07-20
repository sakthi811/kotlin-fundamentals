package com.droiddude.apps.practice.kotlinfundamentals

class SongCatalog(
    val title : String,
    val artist : String,
    val yearPublished : Int,
    val playCount : Int
) {
    val isPopular : Boolean
        get() = playCount >= 1000

    fun printSongDescription() {
        println("$title, performed by $artist, was released in $yearPublished.")
    }
}

fun main() {
    val brunoSong = SongCatalog("We Don't Talk About Bruno", "Encanto Cast", 2022, 1_000_000)
    brunoSong.printSongDescription()
    println(brunoSong.isPopular)
}