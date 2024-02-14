package com.example.weatherapp.data.models.models_current_weather

import com.example.weatherapp.data.utils.Constants
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherCloudModel(
    @SerializedName("id")
    val weatherId: Int,
    @SerializedName("main")
    val weatherMain: String,
    @SerializedName("description")
    val weatherDescription: String,
) : Serializable {
    companion object {
        val unknown = WeatherCloudModel(
            weatherMain = Constants.EMPTY_STRING,
            weatherId = 0,
            weatherDescription = Constants.EMPTY_STRING,
        )
    }
}