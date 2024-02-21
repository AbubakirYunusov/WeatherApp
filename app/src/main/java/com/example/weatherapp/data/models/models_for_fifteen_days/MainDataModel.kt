package com.example.weatherapp.data.models.models_for_fifteen_days

data class MainDataModel(
    val feelsLike: Double,
    val grndLevel: Int,
    val humidity: Int,
    val pressure: Int,
    val seaLevel: Int,
    val temp: Double,
    val tempKf: Double,
    val tempMax: Double,
    val tempMin: Double
)