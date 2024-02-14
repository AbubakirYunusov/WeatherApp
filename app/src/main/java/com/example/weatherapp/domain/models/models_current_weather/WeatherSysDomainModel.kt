package com.example.weatherapp.domain.models.models_current_weather

import java.io.Serializable

data class WeatherSysDomainModel(
    val country: String
) : Serializable {
    companion object {
        val unknown = WeatherSysDomainModel(
            country = ""
        )
    }
}