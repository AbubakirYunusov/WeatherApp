package com.example.weatherapp.presentation.screen.scren_home.component

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.presentation.components.WeatherLottieAnimation
import com.example.weatherapp.presentation.models.models_current_weather.WeatherPresentationModel
import com.example.weatherapp.presentation.screen.scren_home.MainScreenUiState
import java.time.LocalDate
import java.util.Date

@SuppressLint("SimpleDateFormat")
@Composable
fun LoadedWeatherScreens(
    loadedUiState: MainScreenUiState.Success,
    modifier: Modifier = Modifier
) {
    val cityName = loadedUiState.weatherPresentationModel.cityName
    val countryName = loadedUiState.weatherPresentationModel.sys.country
    val sdf = SimpleDateFormat("hh:mm")
    val currentData = sdf.format(Date())
    val currentDayName = LocalDate.now().dayOfWeek.name
    val temperature = (loadedUiState.weatherPresentationModel.weatherMain.weatherTemperature - 273)
    val currentWeatherStatus =
        loadedUiState.weatherPresentationModel.currentWeather.firstOrNull()?.weatherMain.orEmpty()

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "$countryName, $cityName",
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                color = Color.White
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "$currentData — ${
                    currentDayName.lowercase().replaceFirstChar { it.uppercase() }
                }",
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                color = Color.White
            )
            WeatherStateLottie(
                loadedUiState, modifier = Modifier
                    .fillMaxWidth()
                    .size(180.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "${temperature.toInt()}° C",
                fontSize = 40.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                color = Color.White
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = currentWeatherStatus,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                color = Color.White
            )
            WeatherInfoBlock(
                humidity = loadedUiState.weatherPresentationModel.weatherMain.weatherHumidity,
                windSpeed = loadedUiState.weatherPresentationModel.weatherWindInfo.windSpeed,
                pressure = loadedUiState.weatherPresentationModel.weatherMain.weatherPressure,
            )
        }
    }
}

@Composable
fun WeatherStateLottie(
    loadedUiState: MainScreenUiState.Success,
    modifier: Modifier = Modifier,
) {
    loadedUiState.weatherPresentationModel.currentWeather.firstOrNull()?.apply {
        if (isClear) {
            WeatherLottieAnimation(
                modifier = modifier,
                rawFile = R.raw.splash
            )
        } else if (isCloudy) {
            WeatherLottieAnimation(
                modifier = modifier,
                rawFile = R.raw.rainny
            )
        } else if (isMist) {
            WeatherLottieAnimation(
                modifier = modifier,
                rawFile = R.raw.mist
            )
        }
    }
}


@Preview
@Composable
fun LoadedWeatherScreensPreview() {
    MaterialTheme {
        LoadedWeatherScreens(
            loadedUiState = MainScreenUiState.Success(WeatherPresentationModel.unknown)
        )
    }
}