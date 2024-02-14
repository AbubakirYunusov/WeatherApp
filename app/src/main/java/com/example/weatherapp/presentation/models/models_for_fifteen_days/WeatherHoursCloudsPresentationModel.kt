package com.example.weatherapp.presentation.models.models_for_fifteen_days

import java.io.Serializable

data class WeatherHoursCloudsPresentationModel(
    val all: Int,
) : Serializable {
    companion object {
        val unknown = WeatherHoursCloudsPresentationModel(
            all = 0,
        )
    }
}