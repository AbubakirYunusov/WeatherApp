package com.example.weatherapp.domain.models.models_for_fifteen_days

import java.io.Serializable

data class WeatherHoursWindInfoDomainModel(
    val speed: Double,
    val deg: Int,
    val gust: Double,
) : Serializable {
    companion object {
        val unknown = WeatherHoursWindInfoDomainModel (
            speed = 0.0,
            deg = 0,
            gust = 0.0,
        )
    }
}