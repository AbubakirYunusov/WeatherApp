package com.example.weatherapp.presentation.screen.screen_forecast_more

import androidx.compose.runtime.Immutable
import com.example.weatherapp.presentation.models.models_for_fifteen_days.WeatherForFiveDaysResponseUiModel

@Immutable
sealed class MoreForecastUiState {

    @Immutable
    data class Loaded(
        val weatherForFifteenDayRemote: WeatherForFiveDaysResponseUiModel
    ) : MoreForecastUiState()

    data object Loading : MoreForecastUiState()

    @javax.annotation.concurrent.Immutable
    data class Error(
        val massage: String,
        val isErrorWithConnection: Boolean,
    ) : MoreForecastUiState()

}