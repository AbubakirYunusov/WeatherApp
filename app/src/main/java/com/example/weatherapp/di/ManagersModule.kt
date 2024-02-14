package com.example.weatherapp.di

import android.app.Application
import com.example.weatherapp.domain.managers.DefaultGetCurrentLocationManager
import com.example.weatherapp.domain.managers.GetCurrentLocationManager
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ManagersModule {

    @Provides
    fun providesGetCurrentLocationManager(
        application: Application
    ): GetCurrentLocationManager = DefaultGetCurrentLocationManager(
        application = application,
        locationProviderClient = LocationServices.getFusedLocationProviderClient(application)
    )

}