package com.example.weatherapp.presentation.models.models_for_fifteen_days

import java.io.Serializable

data class WeatherHoursListPresentationMode(
    val dt: Int,
    val visibility: Int,
    val pop: Int,
    val dtTxt: String,

    val mainModel: WeatherHoursMainPresentationModel,
    val weather: WeatherHoursCloudPresentationModel,
    val clouds: WeatherHoursCloudsPresentationModel,
    val wind: WeatherHoursWindInfoPresentationModel,
    val sys: WeatherHoursSysPresentationModel,
) : Serializable {
    companion object {
        val unknown = WeatherHoursListPresentationMode(
            dt = 0,
            visibility = 0,
            pop = 0,
            dtTxt = String(),

            mainModel = WeatherHoursMainPresentationModel.unknown,
            weather = WeatherHoursCloudPresentationModel.unknown,
            clouds = WeatherHoursCloudsPresentationModel.unknown,
            wind = WeatherHoursWindInfoPresentationModel.unknown,
            sys = WeatherHoursSysPresentationModel.unknown
        )
    }
}