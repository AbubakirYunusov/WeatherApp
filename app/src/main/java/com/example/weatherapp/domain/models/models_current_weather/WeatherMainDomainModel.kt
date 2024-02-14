package com.example.weatherapp.domain.models.models_current_weather

import java.io.Serializable

data class WeatherMainDomainModel(
    val weatherTemperature: Double,
    val feelsLike: Double,
    val weatherMainTemp: Double,
    val weatherMaxTemp: Double,
    val weatherPressure: Double,
    val weatherHumidity: Int,
) : Serializable {
    companion object{
        val unknown = WeatherMainDomainModel(
            weatherHumidity = 0,
            weatherMainTemp = 0.0,
            weatherMaxTemp = 0.0,
            weatherPressure = 0.0,
            weatherTemperature = 0.0,
            feelsLike = 0.0,
        )
    }
}