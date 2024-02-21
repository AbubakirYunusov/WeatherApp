package com.example.weatherapp.presentation.models.models_for_fifteen_days

data class MainUiModel(
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