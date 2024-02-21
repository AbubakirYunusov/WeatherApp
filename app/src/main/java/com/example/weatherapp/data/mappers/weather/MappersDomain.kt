package com.example.weatherapp.data.mappers.weather

import com.example.weatherapp.data.models.models_current_weather.WeatherCloudModel
import com.example.weatherapp.data.models.models_current_weather.WeatherCloudsModel
import com.example.weatherapp.data.models.models_current_weather.WeatherCoordinateModel
import com.example.weatherapp.data.models.models_current_weather.WeatherDataModel
import com.example.weatherapp.data.models.models_current_weather.WeatherMainModel
import com.example.weatherapp.data.models.models_current_weather.WeatherSysModel
import com.example.weatherapp.data.models.models_current_weather.WeatherWindInfoModel
import com.example.weatherapp.domain.models.models_current_weather.WeatherCloudDomainModel
import com.example.weatherapp.domain.models.models_current_weather.WeatherCloudsDomainModel
import com.example.weatherapp.domain.models.models_current_weather.WeatherCoordinateDomainModel
import com.example.weatherapp.domain.models.models_current_weather.WeatherDomainModel
import com.example.weatherapp.domain.models.models_current_weather.WeatherMainDomainModel
import com.example.weatherapp.domain.models.models_current_weather.WeatherSysDomainModel
import com.example.weatherapp.domain.models.models_current_weather.WeatherWindInfoDomainModel

fun WeatherDataModel.toDomain() = WeatherDomainModel(

    weather = weather.map { it.toDomain() },
    weatherClouds = weatherClouds.toDomain(),
    weatherCoordinate = weatherCoordinate.toDomain(),
    weatherMain = weatherMain.toDomain(),
    weatherWindInfo = weatherWindowInfo.toDomain(),
    weatherBase = weatherBase,
    visibility = visibility,
    cityName = name,
    sys = sys.toDomain()
)

fun WeatherCloudModel.toDomain() = WeatherCloudDomainModel(
    weatherId = weatherId,
    weatherMain = weatherMain,
    weatherDescription = weatherDescription,
)


fun WeatherCloudsModel.toDomain() = WeatherCloudsDomainModel(
    all = all,
)

fun WeatherCoordinateModel.toDomain() = WeatherCoordinateDomainModel(
    latitude = latitude,
    longitude = longitude,
)

fun WeatherMainModel.toDomain() = WeatherMainDomainModel(
    weatherHumidity = weatherHumidity,
    weatherMainTemp = weatherMainTemp,
    weatherMaxTemp = weatherMainTemp,
    weatherPressure = weatherPressure,
    weatherTemperature = weatherTemperature,
    feelsLike = feelsLike,
)

fun WeatherWindInfoModel.toDomain() = WeatherWindInfoDomainModel(
    windDeg = windDeg,
    windSpeed = windSpeed,
)

fun WeatherSysModel.toDomain() = WeatherSysDomainModel(
    country = country
)