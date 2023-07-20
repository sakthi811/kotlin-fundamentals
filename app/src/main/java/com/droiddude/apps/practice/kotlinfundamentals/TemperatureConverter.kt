package com.droiddude.apps.practice.kotlinfundamentals

fun main() {

    var celsiusToFahrenheit = { degree : Double ->
        9.0/5.0 * degree + 32
    }

    var kelvinToCelsius = { kelvin : Double ->
        kelvin - 273.15
    }

    var fahrenheitToKelvin = { fahrenheit : Double ->
        5.0/9.0 * ( fahrenheit - 32) + 273.15
    }

    printFinalTemperature(
        initialMeasurement = 27.0,
        initialUnit = "Celsius",
        finalUnit = "Fahrenheit",
        celsiusToFahrenheit
    )

    printFinalTemperature(
        initialMeasurement = 350.0,
        initialUnit = "Kelvin",
        finalUnit = "Celsius",
        kelvinToCelsius
    )

    printFinalTemperature(
        initialMeasurement = 10.0,
        initialUnit = "Fahrenheit",
        finalUnit = "Kelvin",
        fahrenheitToKelvin
    )
}


fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}