package com.example.weatherapp.data.models.models_current_weather

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherMainModel(
    @SerializedName("temp")
    val weatherTemperature: Double,
    @SerializedName("feels_like")
    val feelsLike: Double,
    @SerializedName("temp_min")
    val weatherMainTemp: Double,
    @SerializedName("temp_max")
    val weatherMaxTemp: Double,
    @SerializedName("pressure")
    val weatherPressure: Double,
    @SerializedName("humidity")
    val weatherHumidity: Int,
) : Serializable {
    companion object{
        val unknown = WeatherMainModel(
            weatherHumidity = 0,
            weatherMainTemp = 0.0,
            weatherMaxTemp = 0.0,
            weatherPressure = 0.0,
            weatherTemperature = 0.0,
            feelsLike = 0.0,
        )
    }
}