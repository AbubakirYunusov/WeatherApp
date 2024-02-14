package com.example.weatherapp.domain.models.models_current_weather

import java.io.Serializable

data class WeatherWindInfoDomainModel(
    val windSpeed: Double,
    val windDeg: Int,
) : Serializable {
    companion object {
        val unknown = WeatherWindInfoDomainModel(
            windSpeed = 0.0,
            windDeg = 0,
        )
    }
}