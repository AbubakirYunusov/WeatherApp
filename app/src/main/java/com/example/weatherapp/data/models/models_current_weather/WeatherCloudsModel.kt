package com.example.weatherapp.data.models.models_current_weather

import java.io.Serializable

data class WeatherCloudsModel(
    val all: Int,
) : Serializable {
    companion object {
        val unknown = WeatherCloudsModel(
            all = 0,
        )
    }
}