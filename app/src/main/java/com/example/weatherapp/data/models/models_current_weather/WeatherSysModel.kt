package com.example.weatherapp.data.models.models_current_weather

import com.example.weatherapp.data.utils.Constants
import java.io.Serializable

data class WeatherSysModel(
    val country: String
) : Serializable {
    companion object {
        val unknown = WeatherSysModel(
            country = Constants.EMPTY_STRING
        )
    }
}