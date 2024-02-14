package com.example.weatherapp.di

import com.example.weatherapp.domain.managers.GetCurrentLocationManager
import com.example.weatherapp.domain.repository.WeatherRepository
import com.example.weatherapp.domain.use_cases.current_weather.DefaultGetCurrentWeatherUseCase
import com.example.weatherapp.domain.use_cases.current_weather.GetCurrentWeatherUseCase
import com.example.weatherapp.domain.use_cases.for_fifteen_days.DefaultGetWeatherForFiveDaysUseCase
import com.example.weatherapp.domain.use_cases.for_fifteen_days.GetWeatherForFiveDaysUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun providesDefaultGetCurrentWeatherUseCase(
        repository: WeatherRepository,
        getCurrentLocationManager: GetCurrentLocationManager,
    ): GetCurrentWeatherUseCase = DefaultGetCurrentWeatherUseCase(
        repository = repository,
        getCurrentLocationManager = getCurrentLocationManager
    )

    @Provides
    fun providesGetWeatherForFiveDaysUseCase(
        repository: WeatherRepository
    ): GetWeatherForFiveDaysUseCase = DefaultGetWeatherForFiveDaysUseCase(
        repository = repository
    )

}