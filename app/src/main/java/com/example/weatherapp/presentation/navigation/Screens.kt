package com.example.weatherapp.presentation.navigation

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import com.example.weatherapp.R

@SuppressLint("SupportAnnotationUsage")
sealed class Screens(
    @StringRes val route: String,
) {
    data object HomeScreen : Screens(R.string.home_screen_route.toString())

    data object Splashscreen : Screens(R.string.splash_screen_route.toString())
}