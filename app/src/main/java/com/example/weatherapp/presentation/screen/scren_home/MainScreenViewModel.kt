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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val getWeatherForFiveDaysUseCase: GetWeatherForFiveDaysUseCase,
) : ViewModel() {

    private val _uiState: MutableStateFlow<MainScreenUiState> =
        MutableStateFlow(MainScreenUiState.Loading)
    val uiState: StateFlow<MainScreenUiState> = _uiState.asStateFlow()

    private val handle = CoroutineExceptionHandler { _, throwable -> }

    init {
        getCurrentWeatherData()
    }

    fun getCurrentWeatherData() {
        viewModelScope.launch(handle + Dispatchers.IO) {
            _uiState.tryEmit(MainScreenUiState.Loading)
            val response = getCurrentWeatherUseCase()
            val result = getWeatherForFiveDaysUseCase()
            when (result.status) {
                ResponseStatus.SUCCESS -> {
                    result.data?.let { weather ->
                        _uiState.tryEmit(
                            MainScreenUiState.Success(
                                weatherHoursPresentationModel = weather.map { it.toUi() }
                            )
                        )
                    }
                }

                ResponseStatus.ERROR -> {
                    response.errorThrowable?.message?.let { massage ->
                        if (response.errorThrowable == UnknownHostException()) {
                            _uiState.tryEmit(
                                MainScreenUiState.Error(
                                    massage = massage,
                                    isErrorWithConnection = true,
                                )
                            )
                        } else {
                            _uiState.tryEmit(
                                MainScreenUiState.Error(
                                    massage = massage,
                                    isErrorWithConnection = false,
                                )
                            )
                        }
                    }
                }
            }

            when (response.status) {
                ResponseStatus.SUCCESS -> {
                    response.data?.let { weather ->
                        _uiState.tryEmit(
                            MainScreenUiState.Success(
                                weatherPresentationModel = weather.toPresentation(),
                            )
                        )
                    }
                }

                ResponseStatus.ERROR -> {
                    response.errorThrowable?.message?.let { massage ->
                        if (response.errorThrowable == UnknownHostException()) {
                            _uiState.tryEmit(
                                MainScreenUiState.Error(
                                    massage = massage,
                                    isErrorWithConnection = true,
                                )
                            )
                        } else {
                            _uiState.tryEmit(
                                MainScreenUiState.Error(
                                    massage = massage,
                                    isErrorWithConnection = false,
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}