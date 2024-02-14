package com.example.weatherapp.domain.models.models_for_fifteen_days

import java.io.Serializable

data class WeatherHoursMainDomainModel(
    val temp: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Int,
    val seaLevel: Int,
    val grndLevel: Int,
    val humidity: Int,
    val tempKf: Double,
) : Serializable {
    companion object {
        val unknown = WeatherHoursMainDomainModel(
            temp = 0.0,
            feelsLike = 0.0,
            tempMin = 0.0,
            tempMax = 0.0,
            pressure = 0,
            seaLevel = 0,
            grndLevel = 0,
            humidity = 0,
            tempKf = 0.0,
        )
    }
}