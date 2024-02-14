package com.example.weatherapp.presentation.screen.scren_splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.presentation.components.WeatherLottieAnimation
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val SPLASH_SCREEN_TIME_MILLIS = 3000L

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onNavigateNext: () -> Unit,
) {

    val systemUiController = rememberSystemUiController()
    val colorBackground = MaterialTheme.colorScheme.background
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        coroutineScope.launch {
            delay(SPLASH_SCREEN_TIME_MILLIS)
            onNavigateNext()
        }
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        WeatherLottieAnimation(
            modifier = modifier.size(220.dp),
            rawFile = R.raw.splash
        )
    }

    SideEffect {
        systemUiController.setStatusBarColor(colorBackground)
        systemUiController.setNavigationBarColor(colorBackground)
    }

}