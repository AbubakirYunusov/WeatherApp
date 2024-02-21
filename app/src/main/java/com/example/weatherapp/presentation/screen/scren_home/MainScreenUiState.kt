package com.example.weatherapp.presentation.screen.scren_home

import com.example.weatherapp.presentation.models.models_current_weather.WeatherPresentationModel
import com.example.weatherapp.presentation.models.models_for_fifteen_days.WeatherForFiveDaysResponseUiModel
import kotlinx.collections.immutable.ImmutableList
import javax.annotation.concurrent.Immutable

@Immutable
sealed class MainScreenUiState {

    @Immutable
    data class Success(
        val currentWeather: WeatherPresentationModel,
        val weatherDayInHours: WeatherForFiveDaysResponseUiModel

    ) : MainScreenUiState()

    data object Loading : MainScreenUiState()

    @Immutable
    data class Error(
        val massage: String,
        val isErrorWithConnection: Boolean,
    ) : MainScreenUiState()
}