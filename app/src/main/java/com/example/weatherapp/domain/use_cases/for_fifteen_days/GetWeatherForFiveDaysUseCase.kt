package com.example.weatherapp.domain.use_cases.for_fifteen_days

import com.example.weatherapp.data.base.model.ResultStatus
import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherCloudDomainModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherForFiveDaysResponseDomainModel

interface GetWeatherForFiveDaysUseCase {

    suspend operator fun invoke():  ResultStatus<List<WeatherCloudDomainModel>>
}