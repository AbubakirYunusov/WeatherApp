package com.example.weatherapp.data.mappers.waather_for_five

import com.example.weatherapp.data.models.models_for_fifteen_days.CityDataModel
import com.example.weatherapp.data.models.models_for_fifteen_days.CloudsDataModel
import com.example.weatherapp.data.models.models_for_fifteen_days.CoordDataModel
import com.example.weatherapp.data.models.models_for_fifteen_days.MainDataModel
import com.example.weatherapp.data.models.models_for_fifteen_days.RainDataModel
import com.example.weatherapp.data.models.models_for_fifteen_days.SysDataModel
import com.example.weatherapp.data.models.models_for_fifteen_days.WeatherCloudDataModel
import com.example.weatherapp.data.models.models_for_fifteen_days.WeatherDataModel
import com.example.weatherapp.data.models.models_for_fifteen_days.WeatherForFiveDaysResponseDataModel
import com.example.weatherapp.data.models.models_for_fifteen_days.WindDataModel
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

fun WeatherForFiveDaysResponseDataModel.toDomain() = WeatherForFiveDaysResponseDomainModel(
    city = city.toDomain(),
    cnt = cnt,
    cod = cod,
    list = list.map { it.toDomain() },
    message = message,
)
fun WindDataModel.toDomain() = WindDomainModel(
    deg = deg,
    gust = gust,
    speed = speed,
)

fun CityDataModel.toDomain() = CityDomainModel(
    country = country,
    coord = coord.toDomain(),
    id = id,
    name = name,
    timezone = timezone,
    population = population,
    sunrise = sunrise,
    sunset = sunset,
)

fun CloudsDataModel.toDomain() = CloudsDomainModel(
    all = all,
)

fun CoordDataModel.toDomain() = CoordDomainModel(
    lat = lat,
    lon = lon,
)

fun MainDataModel.toDomain() = MainDomainModel(
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

fun RainDataModel.toDomain() = RainDomainModel(
    h = h,
)

fun SysDataModel.toDomain() = SysDomainModel(
    pod = pod,
)

fun WeatherCloudDataModel.toDomain() = WeatherCloudDomainModel(
    clouds = clouds.toDomain(),
    dtTxt = dtTxt,
    dt = dt,
    main = main.toDomain(),
    pop = pop,
    rain = rain?.toDomain(),
    sys = sys.toDomain(),
    visibility = visibility,
    wind = wind.toDomain(),
    weather = weather.map { it.toDomain() },
)

fun WeatherDataModel.toDomain() = WeatherDomainModel(
    description = description,
    id = id,
    icon = icon,
    main = main,
)