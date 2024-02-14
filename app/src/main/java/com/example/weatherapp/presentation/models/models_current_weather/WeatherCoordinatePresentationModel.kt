package com.example.weatherapp.presentation.models.models_current_weather

import java.io.Serializable

data class WeatherCoordinatePresentationModel(
    val latitude: Double,
    val longitude: Double,
) : Serializable {
    companion object {
        val unknown = WeatherCoordinatePresentationModel(
            longitude = 0.0,
            latitude = 0.0,
        )
    }
}