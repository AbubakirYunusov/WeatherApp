package com.example.weatherapp.di

import com.example.weatherapp.data.remote.WeatherService
import com.example.weatherapp.data.repository.DefaultWeatherRepository
import com.example.weatherapp.data.utils.Constants.BASE_URl
import com.example.weatherapp.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun providesGetCurrentWeatherRepository(
        service: WeatherService
    ): WeatherRepository {
        return DefaultWeatherRepository(
            service = service
        )
    }

    @Provides
    fun providesWeatherService(
        retrofit: Retrofit
    ): WeatherService {
        return retrofit.create(WeatherService::class.java)
    }

    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()
            )
            .build()
    }
}