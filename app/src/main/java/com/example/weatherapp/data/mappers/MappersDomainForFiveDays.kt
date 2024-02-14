package com.example.weatherapp.data.mappers

import com.example.weatherapp.data.models.models_for_fifteen_days.WeatherHoursCloudModel
import com.example.weatherapp.data.models.models_for_fifteen_days.WeatherHoursCloudsModel
import com.example.weatherapp.data.models.models_for_fifteen_days.WeatherHoursModel
import com.example.weatherapp.data.models.models_for_fifteen_days.WeatherHoursListMode
import com.example.weatherapp.data.models.models_for_fifteen_days.WeatherHoursMainModel
import com.example.weatherapp.data.models.models_for_fifteen_days.WeatherHoursSysModel
import com.example.weatherapp.data.models.models_for_fifteen_days.WeatherHoursWindInfoModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherHoursCloudDomainModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherHoursCloudsDomainModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherHoursDomainModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherHoursDomainListModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherHoursMainDomainModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherHoursSysDomainModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherHoursWindInfoDomainModel

fun WeatherHoursListMode.toDomain() = WeatherHoursDomainListModel(
    dt = dt,
    visibility = visibility,
    pop = pop,
    dtTxt = dtTxt,

    mainModel = mainModel.toDomain(),
    weather = weather.toDomain(),
    clouds = clouds.toDomain(),
    wind = wind.toDomain(),
    sys = sys.toDomain(),
)

fun WeatherHoursMainModel.toDomain() = WeatherHoursMainDomainModel(
    temp = temp,
    feelsLike = feelsLike,
    tempMin = tempMin,
    tempMax = tempMax,
    pressure = pressure,
    grndLevel = grndLevel,
    humidity = humidity,
    tempKf = tempKf,
    seaLevel = seaLevel,
)

fun WeatherHoursCloudModel.toDomain() = WeatherHoursCloudDomainModel(
    id = id,
    main = main,
    description = description,
)

fun WeatherHoursWindInfoModel.toDomain() = WeatherHoursWindInfoDomainModel(
    speed = speed,
    deg = deg,
    gust = gust,
)

fun WeatherHoursCloudsModel.toDomain() = WeatherHoursCloudsDomainModel(
    all = all,
)

fun WeatherHoursModel.toDomain() = WeatherHoursDomainModel(
    list = list.map { it.toDomain() },
)

fun WeatherHoursSysModel.toDomain() = WeatherHoursSysDomainModel(
    pod = pod,
)