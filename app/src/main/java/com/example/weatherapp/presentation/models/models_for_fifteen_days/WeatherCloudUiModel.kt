package com.example.weatherapp.presentation.models.models_for_fifteen_days

data class WeatherCloudUiModel(
    val clouds: CloudsUiModel,
    val dt: Int,
    val dtTxt: String,
    val main: MainUiModel,
    val pop: Double,
    val rain: RainUiModel?,
    val sys: SysUiModel,
    val visibility: Int,
    val weather: List<WeatherUiModel>,
    val wind: WindUiModel
)