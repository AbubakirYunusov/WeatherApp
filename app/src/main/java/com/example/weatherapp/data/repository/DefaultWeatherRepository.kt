package com.example.weatherapp.data.repository

import com.example.weatherapp.data.base.BaseDataSource
import com.example.weatherapp.data.base.model.ResultStatus
import com.example.weatherapp.data.mappers.waather_for_five.toDomain
import com.example.weatherapp.data.mappers.weather.toDomain
import com.example.weatherapp.data.remote.WeatherService
import com.example.weatherapp.domain.models.models_current_weather.WeatherDomainModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.CoordDomainModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherCloudDomainModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherForFiveDaysResponseDomainModel
import com.example.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class DefaultWeatherRepository @Inject constructor(
    private val service: WeatherService

) : WeatherRepository, BaseDataSource() {

    override suspend fun getCurrentWeatherData(
        latitude: Double,
        longitude: Double,
    ): ResultStatus<WeatherDomainModel> {
        val response = invokeResponseRequest {
            service.getCurrentWeather(
                latitude = latitude,
                longitude = longitude,
            )
        }
        return ResultStatus(
            status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.toDomain(),
        )
    }

    override suspend fun getWeatherForFiveDays(
        latitude: Double,
        longitude: Double
    ): ResultStatus<List<WeatherCloudDomainModel>> {
        val response = invokeResponseRequest {
            service.getWeatherForFiveDays(
                latitude = latitude,
                longitude = longitude,
            )
        }
        return ResultStatus(
            status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.list?.map { it.toDomain() }
        )
    }
}