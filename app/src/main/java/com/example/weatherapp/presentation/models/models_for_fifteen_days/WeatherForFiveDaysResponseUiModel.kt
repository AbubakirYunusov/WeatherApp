package com.example.weatherapp.presentation.models.models_for_fifteen_days

data class WeatherForFiveDaysResponseUiModel(
    val city: CityUiModel,
    val cnt: Int,
    val cod: String,
    val list: List<WeatherCloudUiModel>,
    val message: Int
)
