package com.example.weatherapp.domain.models.models_for_fifteen_days

import java.io.Serializable

data class WeatherHoursDomainModel(
    val list: List<WeatherHoursDomainListModel>
) : Serializable {
    companion object {
        val unknown = WeatherHoursDomainModel (
            list = emptyList()
        )
    }
}