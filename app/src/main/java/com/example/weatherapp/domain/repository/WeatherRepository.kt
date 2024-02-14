package com.example.weatherapp.domain.repository

import com.example.weatherapp.data.base.model.ResultStatus
import com.example.weatherapp.domain.models.models_current_weather.WeatherDomainModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherHoursDomainListModel

interface WeatherRepository {

    suspend fun getCurrentWeatherData(
        latitude: Double,
        longitude: Double,
    ) : ResultStatus<WeatherDomainModel>

    suspend fun getWeatherForFiveDays(
        latitude: Double,
        longitude: Double,
    ) : WeatherHoursDomainListModel

}