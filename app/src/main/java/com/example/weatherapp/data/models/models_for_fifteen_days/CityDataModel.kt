package com.example.weatherapp.data.models.models_for_fifteen_days

import com.google.gson.annotations.SerializedName

data class CityDataModel(
    @SerializedName("coord")
    val coord: CoordDataModel,
    @SerializedName("country")
    val country: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("population")
    val population: Int,
    @SerializedName("sunrise")
    val sunrise: Int,
    @SerializedName("sunset")
    val sunset: Int,
    @SerializedName("timezone")
    val timezone: Int
)