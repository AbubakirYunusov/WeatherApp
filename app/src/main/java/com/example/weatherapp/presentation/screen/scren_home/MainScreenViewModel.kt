package com.example.weatherapp.presentation.screen.scren_home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.base.model.ResponseStatus
import com.example.weatherapp.data.mappers.waather_for_five.toUi
import com.example.weatherapp.data.mappers.weather.toPresentation
import com.example.weatherapp.domain.use_cases.current_weather.GetCurrentWeatherUseCase
import com.example.weatherapp.domain.use_cases.for_fifteen_days.GetWeatherForFiveDaysUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val getForecastData: GetWeatherForFiveDaysUseCase,
) : ViewModel() {

    private val _uiState: MutableStateFlow<MainScreenUiState> =
        MutableStateFlow(MainScreenUiState.Loading)
    val uiState: StateFlow<MainScreenUiState> = _uiState.asStateFlow()

    private val handle = CoroutineExceptionHandler { _, throwable -> }

    init {
        getCurrentWeatherData()
    }

    private fun getCurrentWeatherData() {
        viewModelScope.launch(handle + Dispatchers.IO) {
            _uiState.tryEmit(MainScreenUiState.Loading)
            val currentWeatherDeffered = async {
                getCurrentWeatherUseCase()
            }
            val forecastWeatherDeffered = async {
                getForecastData()
            }
            val responseCurrentWeather = currentWeatherDeffered.await()
            val responseForecastWeather = forecastWeatherDeffered.await()
            if (responseCurrentWeather.status == ResponseStatus.SUCCESS &&
                responseForecastWeather.status == ResponseStatus.SUCCESS
            ) {
                responseCurrentWeather.data?.let { currentWeather ->
                    responseForecastWeather.data?.let { forecastWeather ->
                        _uiState.update {
                            MainScreenUiState.Success(
                                currentWeather = currentWeather.toPresentation(),
                                weatherDayInHours = forecastWeather.toUi()
                            )
                        }
                    }
                }
            }
        }
    }
}