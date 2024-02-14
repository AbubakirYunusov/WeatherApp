package com.example.weatherapp.presentation.models.models_current_weather

import java.io.Serializable

data class WeatherSysPresentationModel(
    val country: String
) : Serializable {
    companion object {
        val unknown = WeatherSysPresentationModel(
            country = ""
        )
    }
}