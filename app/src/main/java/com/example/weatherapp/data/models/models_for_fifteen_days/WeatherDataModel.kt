package com.example.weatherapp.data.models.models_for_fifteen_days


import com.google.gson.annotations.SerializedName

data class WeatherDataModel(
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val main: String
)