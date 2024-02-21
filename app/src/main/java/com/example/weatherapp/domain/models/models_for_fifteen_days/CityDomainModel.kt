package com.example.weatherapp.domain.models.models_for_fifteen_days

data class CityDomainModel(
    val coord: CoordDomainModel,
    val country: String,
    val id: Int,
    val name: String,
    val population: Int,
    val sunrise: Int,
    val sunset: Int,
    val timezone: Int
)