package com.example.weatherapp.presentation.screen.scren_home

import com.example.weatherapp.presentation.models.models_current_weather.WeatherPresentationModel
import javax.annotation.concurrent.Immutable

@Immutable
sealed class MainScreenUiState {

    @Immutable
    data class Success(
        val weatherPresentationModel: WeatherPresentationModel
    ): MainScreenUiState()

    data object Loading : MainScreenUiState()

    @Immutable
    data class Error(
        val massage: String,
        val isErrorWithConnection: Boolean,
    ): MainScreenUiState()
}