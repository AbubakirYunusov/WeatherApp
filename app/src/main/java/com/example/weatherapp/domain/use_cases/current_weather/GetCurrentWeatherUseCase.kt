package com.example.weatherapp.domain.use_cases.current_weather

import com.example.weatherapp.data.base.model.ResultStatus
import com.example.weatherapp.domain.models.models_current_weather.WeatherDomainModel

interface GetCurrentWeatherUseCase {

    suspend operator fun invoke(): ResultStatus<WeatherDomainModel>
}