package com.example.weatherapp.domain.models.models_current_weather

import java.io.Serializable


data class WeatherDomainModel(
    val weatherCoordinate: WeatherCoordinateDomainModel,
    val weather: List<WeatherCloudDomainModel>,
    val weatherBase: String,
    val weatherMain: WeatherMainDomainModel,
    val visibility: Int,
    val weatherWindInfo: WeatherWindInfoDomainModel,
    val weatherClouds: WeatherCloudsDomainModel,
    val cityName: String,
    val sys: WeatherSysDomainModel,
) : Serializable {
    companion object {
        val unknown = WeatherDomainModel(
            weatherBase = "",
            weather = listOf(WeatherCloudDomainModel.unknown),
            weatherClouds = WeatherCloudsDomainModel.unknown,
            weatherCoordinate = WeatherCoordinateDomainModel.unknown,
            weatherMain = WeatherMainDomainModel.unknown,
            weatherWindInfo = WeatherWindInfoDomainModel.unknown,
            cityName = "",
            visibility = 0,
            sys = WeatherSysDomainModel.unknown,
        )
    }
}