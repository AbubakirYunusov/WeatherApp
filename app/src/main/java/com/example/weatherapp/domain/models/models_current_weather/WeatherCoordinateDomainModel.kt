package com.example.weatherapp.domain.models.models_current_weather

import java.io.Serializable

data class WeatherCoordinateDomainModel(
    val latitude: Double,
    val longitude: Double,
) : Serializable {
    companion object {
        val unknown = WeatherCoordinateDomainModel(
            longitude = 0.0,
            latitude = 0.0,
        )
    }
}