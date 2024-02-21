package com.example.weatherapp.data.models.models_for_fifteen_days


import com.google.gson.annotations.SerializedName

data class WeatherCloudDataModel(
    @SerializedName("clouds")
    val clouds: CloudsDataModel,
    @SerializedName("dt")
    val dt: Int,
    @SerializedName("dt_txt")
    val dtTxt: String,
    @SerializedName("main")
    val main: MainDataModel,
    @SerializedName("pop")
    val pop: Double,
    @SerializedName("rain")
    val rain: RainDataModel?,
    @SerializedName("sys")
    val sys: SysDataModel,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("weather")
    val weather: List<WeatherDataModel>,
    @SerializedName("wind")
    val wind: WindDataModel
)