package com.example.weatherapp.domain.models.models_current_weather

import java.io.Serializable

data class WeatherCloudDomainModel(
    val weatherId: Int,
    val weatherMain: String,
    val weatherDescription: String,
) : Serializable {
    companion object {
        val unknown = WeatherCloudDomainModel(
            weatherMain = String(),
            weatherId = 0,
            weatherDescription = String(),
        )
    }
}