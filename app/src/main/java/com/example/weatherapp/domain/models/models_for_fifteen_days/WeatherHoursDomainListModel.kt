package com.example.weatherapp.domain.models.models_for_fifteen_days

import java.io.Serializable

data class WeatherHoursDomainListModel(
    val dt: Int,
    val visibility: Int,
    val pop: Int,
    val dtTxt: String,

    val mainModel: WeatherHoursMainDomainModel,
    val weather: WeatherHoursCloudDomainModel,
    val clouds: WeatherHoursCloudsDomainModel,
    val wind: WeatherHoursWindInfoDomainModel,
    val sys: WeatherHoursSysDomainModel,
) : Serializable {
    companion object {
        val unknown = WeatherHoursDomainListModel(
            dt = 0,
            visibility = 0,
            pop = 0,
            dtTxt = String(),

            mainModel = WeatherHoursMainDomainModel.unknown,
            weather = WeatherHoursCloudDomainModel.unknown,
            clouds = WeatherHoursCloudsDomainModel.unknown,
            wind = WeatherHoursWindInfoDomainModel.unknown,
            sys = WeatherHoursSysDomainModel.unknown
        )
    }
}