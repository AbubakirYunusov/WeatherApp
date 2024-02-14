package com.example.weatherapp.data.models.models_for_fifteen_days

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherHoursMainModel(
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("feels_like")
    val feelsLike: Double,
    @SerializedName("temp_min")
    val tempMin: Double,
    @SerializedName("temp_max")
    val tempMax: Double,
    @SerializedName("pressure")
    val pressure: Int,
    @SerializedName("sea_level")
    val seaLevel: Int,
    @SerializedName("grnd_level")
    val grndLevel: Int,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("temp_kf")
    val tempKf: Double,
) : Serializable {
    companion object {
        val unknown = WeatherHoursMainModel(
            temp = 0.0,
            feelsLike = 0.0,
            tempMin = 0.0,
            tempMax = 0.0,
            pressure = 0,
            seaLevel = 0,
            grndLevel = 0,
            humidity = 0,
            tempKf = 0.0,
        )
    }
}