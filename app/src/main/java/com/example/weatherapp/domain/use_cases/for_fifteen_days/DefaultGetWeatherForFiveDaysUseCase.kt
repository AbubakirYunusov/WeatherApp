package com.example.weatherapp.domain.use_cases.for_fifteen_days

import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherHoursDomainListModel
import com.example.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class DefaultGetWeatherForFiveDaysUseCase @Inject constructor (
    private val repository: WeatherRepository
) : GetWeatherForFiveDaysUseCase {

    override suspend fun invoke(
        latitude: Double,
        longitude: Double
    ): WeatherHoursDomainListModel  = repository.getWeatherForFiveDays(
        longitude = longitude,
        latitude = latitude,
    )
}