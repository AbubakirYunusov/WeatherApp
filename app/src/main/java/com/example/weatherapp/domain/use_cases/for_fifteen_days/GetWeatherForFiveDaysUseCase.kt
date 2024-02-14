package com.example.weatherapp.domain.use_cases.for_fifteen_days

import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherHoursDomainListModel

interface GetWeatherForFiveDaysUseCase {

    suspend operator fun invoke(
        latitude: Double,
        longitude: Double,
    ): WeatherHoursDomainListModel
}