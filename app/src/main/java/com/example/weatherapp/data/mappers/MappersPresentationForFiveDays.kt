package com.example.weatherapp.data.mappers

import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherHoursCloudDomainModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherHoursCloudsDomainModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherHoursDomainListModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherHoursDomainModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherHoursMainDomainModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherHoursSysDomainModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherHoursWindInfoDomainModel
import com.example.weatherapp.presentation.models.models_for_fifteen_days.WeatherHoursCloudPresentationModel
import com.example.weatherapp.presentation.models.models_for_fifteen_days.WeatherHoursCloudsPresentationModel
import com.example.weatherapp.presentation.models.models_for_fifteen_days.WeatherHoursListPresentationMode
import com.example.weatherapp.presentation.models.models_for_fifteen_days.WeatherHoursMainPresentationModel
import com.example.weatherapp.presentation.models.models_for_fifteen_days.WeatherHoursPresentationModel
import com.example.weatherapp.presentation.models.models_for_fifteen_days.WeatherHoursSysPresentationModel
import com.example.weatherapp.presentation.models.models_for_fifteen_days.WeatherHoursWindInfoPresentationModel

fun WeatherHoursDomainListModel.toPresentation() = WeatherHoursListPresentationMode(
    dt = dt,
    visibility = visibility,
    pop = pop,
    dtTxt = dtTxt,

    mainModel = mainModel.toPresentation(),
    weather = weather.toPresentation(),
    clouds = clouds.toPresentation(),
    wind = wind.toPresentation(),
    sys = sys.toPresentation(),
)

fun WeatherHoursMainDomainModel.toPresentation() = WeatherHoursMainPresentationModel(
    temp = temp,
    feelsLike = feelsLike,
    tempMax = tempMax,
    tempMin = tempMin,
    humidity = humidity,
    tempKf = tempKf,
    seaLevel = seaLevel,
    pressure = pressure,
    grndLevel = grndLevel,


)

fun WeatherHoursCloudDomainModel.toPresentation() = WeatherHoursCloudPresentationModel(
    id = id,
    main = main,
    description = description,

)

fun WeatherHoursWindInfoDomainModel.toPresentation() = WeatherHoursWindInfoPresentationModel(
    deg = deg,
    speed = speed,
    gust = gust,

)

fun WeatherHoursCloudsDomainModel.toPresentation() = WeatherHoursCloudsPresentationModel(
    all = all,
)

fun WeatherHoursDomainModel.toPresentation() = WeatherHoursPresentationModel(
    list = list.map { it.toPresentation() },
)

fun WeatherHoursSysDomainModel.toPresentation() = WeatherHoursSysPresentationModel(
    pod = pod,
)