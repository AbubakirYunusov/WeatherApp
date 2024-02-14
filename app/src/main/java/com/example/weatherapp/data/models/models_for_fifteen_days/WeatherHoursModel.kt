package com.example.weatherapp.data.models.models_for_fifteen_days

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherHoursModel(
    @SerializedName("list")
    val list: List<WeatherHoursListMode>
) : Serializable {
    companion object {
        val unknown =  WeatherHoursModel (
            list = emptyList()
        )
    }
}