package com.example.weatherapp.presentation.models.models_for_fifteen_days

data class CityUiModel(
    val coord: CoordUiModel,
    val country: String,
    val id: Int,
    val name: String,
    val population: Int,
    val sunrise: Int,
    val sunset: Int,
    val timezone: Int
)