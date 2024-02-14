package com.example.weatherapp.data.models.models_current_weather

import com.example.weatherapp.data.utils.Constants.EMPTY_STRING
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherDataModel(
    @SerializedName("coord")
    val weatherCoordinate: WeatherCoordinateModel,
    @SerializedName("weather")
    val weather: List<WeatherCloudModel>,
    @SerializedName("base")
    val weatherBase:String,
    @SerializedName("main")
    val weatherMain: WeatherMainModel,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("wind")
    val weatherWindowInfo: WeatherWindInfoModel,
    @SerializedName("clouds")
    val weatherClouds: WeatherCloudsModel,
    @SerializedName("name")
    val name:String,
    @SerializedName("sys")
    val sys: WeatherSysModel,
) : Serializable {
    companion object {
        val unknown = WeatherDataModel(
            weatherCoordinate = WeatherCoordinateModel.unknown,
            weather = listOf(WeatherCloudModel.unknown),
            weatherBase = EMPTY_STRING,
            weatherClouds = WeatherCloudsModel.unknown,
            weatherMain = WeatherMainModel.unknown,
            weatherWindowInfo = WeatherWindInfoModel.unknown,
            visibility = 0,
            name = EMPTY_STRING,
            sys = WeatherSysModel.unknown,
        )
    }
}