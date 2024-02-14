package com.example.weatherapp.presentation.models.models_current_weather

import androidx.compose.runtime.Stable
import java.io.Serializable

@Stable
data class WeatherPresentationModel(
    val weatherCoordinate: WeatherCoordinatePresentationModel,
    val currentWeather: List<WeatherCloudPresentationModel>,
    val weatherBase: String,
    val weatherMain: WeatherMainPresentationModel,
    val visibility: Int,
    val weatherWindInfo: WeatherWindInfoPresentationModel,
    val weatherClouds: WeatherCloudsPresentationModel,
    val cityName: String,
    val sys: WeatherSysPresentationModel,
) : Serializable {
    companion object {
        val unknown = WeatherPresentationModel(
            weatherBase = "",
            currentWeather = listOf(WeatherCloudPresentationModel.unknown),
            weatherClouds = WeatherCloudsPresentationModel.unknown,
            weatherCoordinate = WeatherCoordinatePresentationModel.unknown,
            weatherMain = WeatherMainPresentationModel.unknown,
            weatherWindInfo = WeatherWindInfoPresentationModel.unknown,
            cityName = "",
            visibility = 0,
            sys = WeatherSysPresentationModel.unknown,
        )
    }
}