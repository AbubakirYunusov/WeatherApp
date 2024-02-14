package com.example.weatherapp.presentation.models.models_current_weather

import java.io.Serializable

data class WeatherCloudPresentationModel(
    val weatherId: Int,
    val weatherMain: String,
    val weatherDescription: String,
) : Serializable {

    val isClear = weatherMain == "Clear"
    val isCloudy = weatherMain == "Clouds"
    val isMist = weatherMain == "Mist" || weatherMain == "Smoke"


    companion object {
        val unknown = WeatherCloudPresentationModel(
            weatherMain = String(),
            weatherId = 0,
            weatherDescription = String(),
        )
    }
}