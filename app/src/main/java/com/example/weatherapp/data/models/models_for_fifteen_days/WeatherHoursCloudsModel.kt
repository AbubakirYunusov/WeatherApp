package com.example.weatherapp.data.models.models_for_fifteen_days

import java.io.Serializable

data class WeatherHoursCloudsModel(
    val all: Int,
) : Serializable {
    companion object {
        val unknown = WeatherHoursCloudsModel(
            all = 0,
        )
    }
}