package com.example.weatherapp.data.models.models_for_fifteen_days


import com.google.gson.annotations.SerializedName

data class WindDataModel(
    @SerializedName("deg")
    val deg: Int,
    @SerializedName("gust")
    val gust: Double,
    @SerializedName("speed")
    val speed: Double
)