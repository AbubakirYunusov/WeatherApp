package com.example.weatherapp.data.models.models_for_fifteen_days


import com.google.gson.annotations.SerializedName

data class CloudsDataModel(
    @SerializedName("all")
    val all: Int
)