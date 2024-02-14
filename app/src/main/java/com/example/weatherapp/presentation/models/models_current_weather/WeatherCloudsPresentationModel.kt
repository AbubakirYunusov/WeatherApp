package com.example.weatherapp.presentation.models.models_current_weather

import java.io.Serializable

data class WeatherCloudsPresentationModel(
    val all: Int,
) : Serializable {
    companion object {
        val unknown = WeatherCloudsPresentationModel(
            all = 0,
        )
    }
}