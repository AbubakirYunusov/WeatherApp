package com.example.weatherapp.presentation.screen.screen_forecast_more

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.use_cases.for_fifteen_days.GetWeatherForFiveDaysUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoreForecastViewModel @Inject constructor(
    private val getWeatherForFifteendays: GetWeatherForFiveDaysUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<MoreForecastUiState>(MoreForecastUiState.Loading)
    val uiState: StateFlow<MoreForecastUiState> = _uiState.asStateFlow()

    private fun fethcWeatherForecast() {
        viewModelScope.launch {

        }
    }

}