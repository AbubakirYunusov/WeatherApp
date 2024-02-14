package com.example.weatherapp.presentation.models.models_for_fifteen_days

import java.io.Serializable

data class WeatherHoursSysPresentationModel(
    val pod: String,
) : Serializable {
    companion object {
        val unknown = WeatherHoursSysPresentationModel (
            pod = String(),
        )
    }
}