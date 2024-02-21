package com.example.weatherapp.domain.models.models_for_fifteen_days

data class WeatherCloudDomainModel(
    val clouds: CloudsDomainModel,
    val dt: Int,
    val dtTxt: String,
    val main: MainDomainModel,
    val pop: Double,
    val rain: RainDomainModel?,
    val sys: SysDomainModel,
    val visibility: Int,
    val weather: List<WeatherDomainModel>,
    val wind: WindDomainModel
)