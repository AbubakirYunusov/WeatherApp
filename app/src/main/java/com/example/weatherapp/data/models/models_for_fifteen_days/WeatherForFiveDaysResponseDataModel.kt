package com.example.weatherapp.data.models.models_for_fifteen_days


import com.google.gson.annotations.SerializedName

data class WeatherForFiveDaysResponseDataModel(
    @SerializedName("city")
    val city: CityDataModel,
    @SerializedName("cnt")
    val cnt: Int,
    @SerializedName("cod")
    val cod: String,
    @SerializedName("list")
    val list: List<WeatherCloudDataModel>,
    @SerializedName("message")
    val message: Int
)