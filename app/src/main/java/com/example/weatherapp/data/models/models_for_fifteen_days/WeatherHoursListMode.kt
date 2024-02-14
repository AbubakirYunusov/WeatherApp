package com.example.weatherapp.data.models.models_for_fifteen_days

import com.example.weatherapp.data.utils.Constants
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherHoursListMode(
    @SerializedName("dt")
    val dt: Int,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("pop")
    val pop: Int,
    @SerializedName("dt_txt")
    val dtTxt: String,
    @SerializedName("main")
    val mainModel: WeatherHoursMainModel,
    @SerializedName("weather")
    val weather: WeatherHoursCloudModel,
    @SerializedName("clouds")
    val clouds: WeatherHoursCloudsModel,
    @SerializedName("wind")
    val wind: WeatherHoursWindInfoModel,
    @SerializedName("sys")
    val sys: WeatherHoursSysModel,

    ) : Serializable {
    companion object {
        val unknown = WeatherHoursListMode(
            dt = 0,
            visibility = 0,
            pop = 0,
            dtTxt = Constants.EMPTY_STRING,

            mainModel = WeatherHoursMainModel.unknown,
            weather = WeatherHoursCloudModel.unknown,
            clouds = WeatherHoursCloudsModel.unknown,
            wind = WeatherHoursWindInfoModel.unknown,
            sys = WeatherHoursSysModel.unknown
        )
    }
}