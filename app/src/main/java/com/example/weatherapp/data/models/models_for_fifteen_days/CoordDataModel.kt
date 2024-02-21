package com.example.weatherapp.data.models.models_for_fifteen_days


import com.google.gson.annotations.SerializedName

data class CoordDataModel(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double
)