package com.example.weatherapp.presentation.models.models_for_fifteen_days

import java.io.Serializable

data class WeatherHoursCloudPresentationModel(
    val id: Int,
    val main: String,
    val description: String,
) : Serializable {
    companion object {
        val unknown = WeatherHoursCloudPresentationModel(
            main = String(),
            id = 0,
            description = String(),
        )
    }
}