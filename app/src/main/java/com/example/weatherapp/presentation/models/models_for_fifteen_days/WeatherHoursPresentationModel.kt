package com.example.weatherapp.presentation.models.models_for_fifteen_days

import java.io.Serializable

data class WeatherHoursPresentationModel(
    val list: List<WeatherHoursListPresentationMode>
) : Serializable {
    companion object {
        val unknown = WeatherHoursPresentationModel (
            list = emptyList()
        )
    }
}