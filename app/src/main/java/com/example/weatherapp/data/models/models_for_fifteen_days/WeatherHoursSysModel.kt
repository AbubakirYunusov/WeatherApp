package com.example.weatherapp.data.models.models_for_fifteen_days

import com.example.weatherapp.data.utils.Constants
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherHoursSysModel(
    @SerializedName("pod")
    val pod: String,
) : Serializable {
    companion object {
        val unknown = WeatherHoursSysModel (
            pod = Constants.EMPTY_STRING,
        )
    }
}