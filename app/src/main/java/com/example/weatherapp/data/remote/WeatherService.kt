package com.example.weatherapp.data.remote

import com.example.weatherapp.data.models.models_current_weather.WeatherDataModel
import com.example.weatherapp.data.models.models_for_fifteen_days.WeatherForFiveDaysResponseDataModel
import com.example.weatherapp.data.utils.Constants.GET_CURRENT_DATA
import com.example.weatherapp.data.utils.Constants.GET_WEATHER_FOR_5_DAYS_EVERY_THREE_HOURS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET(GET_CURRENT_DATA)
    suspend fun getCurrentWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
    ) : Response<WeatherDataModel>

    @GET(GET_WEATHER_FOR_5_DAYS_EVERY_THREE_HOURS)
    suspend fun getWeatherForFiveDays(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
    ) : Response<WeatherForFiveDaysResponseDataModel>

}