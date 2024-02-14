package com.example.weatherapp.presentation.models.models_current_weather

import java.io.Serializable

data class WeatherWindInfoPresentationModel(
    val windSpeed: Double,
    val windDeg: Int,
) : Serializable {
    companion object {
        val unknown = WeatherWindInfoPresentationModel(
            windSpeed = 0.0,
            windDeg = 0,
        )
    }
}