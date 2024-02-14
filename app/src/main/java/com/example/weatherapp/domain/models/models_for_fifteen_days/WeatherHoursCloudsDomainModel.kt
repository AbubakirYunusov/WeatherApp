package com.example.weatherapp.domain.models.models_for_fifteen_days

import java.io.Serializable

data class WeatherHoursCloudsDomainModel(
    val all: Int,
) : Serializable {
    companion object {
        val unknown = WeatherHoursCloudsDomainModel(
            all = 0,
        )
    }
}