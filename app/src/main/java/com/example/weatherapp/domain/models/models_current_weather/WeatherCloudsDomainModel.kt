package com.example.weatherapp.domain.models.models_current_weather

import java.io.Serializable

data class WeatherCloudsDomainModel(
    val all: Int,
) : Serializable {
    companion object {
        val unknown = WeatherCloudsDomainModel(
            all = 0,
        )
    }
}