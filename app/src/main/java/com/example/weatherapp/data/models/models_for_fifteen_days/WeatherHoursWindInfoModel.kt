package com.example.weatherapp.data.models.models_for_fifteen_days

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherHoursWindInfoModel(
    @SerializedName("speed")
    val speed: Double,
    @SerializedName("deg")
    val deg: Int,
    @SerializedName("gust")
    val gust: Double,
) : Serializable {
    companion object {
        val unknown = WeatherHoursWindInfoModel (
            speed = 0.0,
            deg = 0,
            gust = 0.0,
        )
    }
}