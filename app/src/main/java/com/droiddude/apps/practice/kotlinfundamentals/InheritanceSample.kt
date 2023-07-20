package com.droiddude.apps.practice.kotlinfundamentals

class FoldablePhone(private var isFolded : Boolean) : Phone() {

    override fun switchOn() {
        isScreenLightOn = !isFolded
    }

    fun fold() {
        isFolded = true
    }

    fun unfold() {
        isFolded = false
    }
}

open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

fun main() {
    val foldablePhone = FoldablePhone(isFolded = true)
    foldablePhone.unfold()
    //foldablePhone.switchOn()
    foldablePhone.checkPhoneScreenLight()
    foldablePhone.switchOff()
}