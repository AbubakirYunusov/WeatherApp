package com.example.weatherapp.domain.use_cases.for_fifteen_days

import com.example.weatherapp.data.base.model.ResultStatus
import com.example.weatherapp.domain.managers.GetCurrentLocationManager
import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherForFiveDaysResponseDomainModel
import com.example.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class DefaultGetWeatherForFiveDaysUseCase @Inject constructor(
    private val repository: WeatherRepository,
    private val getCurrentLocationManager: GetCurrentLocationManager
) : GetWeatherForFiveDaysUseCase {

    override suspend fun invoke(): ResultStatus<WeatherForFiveDaysResponseDomainModel> {
        val currentLocation = getCurrentLocationManager.getCurrentLocation()
        return if (currentLocation != null) repository.getWeatherForFiveDays(
            latitude = currentLocation.latitude,
            longitude = currentLocation.longitude,
        ) else return repository.getWeatherForFiveDays(0.0, 0.0)
    }
}