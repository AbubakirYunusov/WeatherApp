package com.example.weatherapp.data.models.models_for_fifteen_days

import com.example.weatherapp.data.utils.Constants
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherHoursCloudModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val main: String,
    @SerializedName("description")
    val description: String,
) : Serializable {
    companion object {
        val unknown = WeatherHoursCloudModel(
            main = Constants.EMPTY_STRING,
            id = 0,
            description = Constants.EMPTY_STRING,
        )
    }
}