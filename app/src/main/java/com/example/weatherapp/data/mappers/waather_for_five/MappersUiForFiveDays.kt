package com.example.weatherapp.data.mappers.waather_for_five

import com.example.weatherapp.domain.models.models_for_fifteen_days.CityDomainModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.CloudsDomainModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.CoordDomainModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.MainDomainModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.RainDomainModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.SysDomainModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherCloudDomainModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherDomainModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.WeatherForFiveDaysResponseDomainModel
import com.example.weatherapp.domain.models.models_for_fifteen_days.WindDomainModel
import com.example.weatherapp.presentation.models.models_for_fifteen_days.CityUiModel
import com.example.weatherapp.presentation.models.models_for_fifteen_days.CloudsUiModel
import com.example.weatherapp.presentation.models.models_for_fifteen_days.CoordUiModel
import com.example.weatherapp.presentation.models.models_for_fifteen_days.MainUiModel
import com.example.weatherapp.presentation.models.models_for_fifteen_days.RainUiModel
import com.example.weatherapp.presentation.models.models_for_fifteen_days.SysUiModel
import com.example.weatherapp.presentation.models.models_for_fifteen_days.WeatherCloudUiModel
import com.example.weatherapp.presentation.models.models_for_fifteen_days.WeatherForFiveDaysResponseUiModel
import com.example.weatherapp.presentation.models.models_for_fifteen_days.WeatherUiModel
import com.example.weatherapp.presentation.models.models_for_fifteen_days.WindUiModel

fun WeatherForFiveDaysResponseDomainModel.toUi() = WeatherForFiveDaysResponseUiModel(
    city = city.toUi(),
    cnt = cnt,
    cod = cod,
    list = list.map { it.toUi() },
    message = message,
)
fun WindDomainModel.toUi() = WindUiModel(
    deg = deg,
    gust = gust,
    speed = speed,
)

fun CityDomainModel.toUi() = CityUiModel(
    country = country,
    coord = coord.toUi(),
    id = id,
    name = name,
    timezone = timezone,
    population = population,
    sunrise = sunrise,
    sunset = sunset,
)

fun CloudsDomainModel.toUi() = CloudsUiModel(
    all = all,
)

fun CoordDomainModel.toUi() = CoordUiModel(
    lat = lat,
    lon = lon,
)

fun MainDomainModel.toUi() = MainUiModel(
    feelsLike = feelsLike,
    grndLevel = grndLevel,
    humidity = humidity,
    pressure = pressure,
    seaLevel = seaLevel,
    tempKf = tempKf,
    tempMin = tempMin,
    temp = temp,
    tempMax = tempMax
)

fun RainDomainModel.toUi() = RainUiModel(
    h = h,
)

fun SysDomainModel.toUi() = SysUiModel(
    pod = pod,
)

fun WeatherCloudDomainModel.toUi() = WeatherCloudUiModel(
    clouds = clouds.toUi(),
    dtTxt = dtTxt,
    dt = dt,
    main = main.toUi(),
    pop = pop,
    rain = rain?.toUi(),
    sys = sys.toUi(),
    visibility = visibility,
    wind = wind.toUi(),
    weather = weather.map { it.toUi() },
)

fun WeatherDomainModel.toUi() = WeatherUiModel(
    description = description,
    id = id,
    icon = icon,
    main = main,
)