package com.example.weatherapp.data.mappers

import com.example.weatherapp.domain.models.models_current_weather.WeatherCloudDomainModel
import com.example.weatherapp.domain.models.models_current_weather.WeatherCloudsDomainModel
import com.example.weatherapp.domain.models.models_current_weather.WeatherCoordinateDomainModel
import com.example.weatherapp.domain.models.models_current_weather.WeatherDomainModel
import com.example.weatherapp.domain.models.models_current_weather.WeatherMainDomainModel
import com.example.weatherapp.domain.models.models_current_weather.WeatherSysDomainModel
import com.example.weatherapp.domain.models.models_current_weather.WeatherWindInfoDomainModel
import com.example.weatherapp.presentation.models.models_current_weather.WeatherCloudPresentationModel
import com.example.weatherapp.presentation.models.models_current_weather.WeatherCloudsPresentationModel
import com.example.weatherapp.presentation.models.models_current_weather.WeatherCoordinatePresentationModel
import com.example.weatherapp.presentation.models.models_current_weather.WeatherMainPresentationModel
import com.example.weatherapp.presentation.models.models_current_weather.WeatherPresentationModel
import com.example.weatherapp.presentation.models.models_current_weather.WeatherSysPresentationModel
import com.example.weatherapp.presentation.models.models_current_weather.WeatherWindInfoPresentationModel


fun WeatherDomainModel.toPresentation() = WeatherPresentationModel(
    currentWeather = weather.map { it.toPresentation() },
    weatherClouds = weatherClouds.toPresentation(),
    weatherCoordinate = weatherCoordinate.toPresentation(),
    weatherMain = weatherMain.toPresentation(),
    weatherWindInfo = weatherWindInfo.toPresentation(),
    weatherBase = weatherBase,
    visibility = visibility,
    cityName = cityName,
    sys = sys.toPresentation()
)

fun WeatherCloudDomainModel.toPresentation() = WeatherCloudPresentationModel(
    weatherId = weatherId,
    weatherMain = weatherMain,
    weatherDescription = weatherDescription,
)

fun WeatherCloudsDomainModel.toPresentation() = WeatherCloudsPresentationModel(
    all = all,
)

fun WeatherCoordinateDomainModel.toPresentation() = WeatherCoordinatePresentationModel(
    latitude = latitude,
    longitude = longitude,
)

fun WeatherMainDomainModel.toPresentation() = WeatherMainPresentationModel(
    weatherHumidity = weatherHumidity,
    weatherMainTemp = weatherMainTemp,
    weatherMaxTemp = weatherMainTemp,
    weatherPressure = weatherPressure,
    weatherTemperature = weatherTemperature,
    feelsLike = feelsLike,
)

fun WeatherWindInfoDomainModel.toPresentation() = WeatherWindInfoPresentationModel(
    windDeg = windDeg,
    windSpeed = windSpeed,
)

fun WeatherSysDomainModel.toPresentation() = WeatherSysPresentationModel(
    country = country
)