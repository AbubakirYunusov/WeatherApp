package com.example.weatherapp.data.models.models_for_fifteen_days


import com.google.gson.annotations.SerializedName

data class RainDataModel(
    @SerializedName("3h")
    val h: Double
)