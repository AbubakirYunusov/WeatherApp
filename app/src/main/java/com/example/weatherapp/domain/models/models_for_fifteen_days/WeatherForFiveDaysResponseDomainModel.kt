package com.example.weatherapp.domain.models.models_for_fifteen_days

data class WeatherForFiveDaysResponseDomainModel(
    val city: CityDomainModel,
    val cnt: Int,
    val cod: String,
    val list: List<WeatherCloudDomainModel>,
    val message: Int
)