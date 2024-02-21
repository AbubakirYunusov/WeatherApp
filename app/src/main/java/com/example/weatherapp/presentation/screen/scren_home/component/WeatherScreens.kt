package com.example.weatherapp.presentation.screen.scren_home.component

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.presentation.components.WeatherLottieAnimation
import com.example.weatherapp.presentation.screen.scren_home.MainScreenUiState
import com.example.weatherapp.presentation.theme.dp12
import com.example.weatherapp.presentation.theme.dp8
import java.time.LocalDate
import java.util.Date

@SuppressLint("SimpleDateFormat")
@Composable
fun LoadedWeatherScreens(
    loadedUiState: MainScreenUiState.Success,
    modifier: Modifier = Modifier,
    onNavigateToMore: () -> Unit,
) {
    val cityName = loadedUiState.currentWeather.cityName
    val countryName = loadedUiState.currentWeather.sys.country
    val sdf = SimpleDateFormat("hh:mm")
    val currentData = sdf.format(Date())
    val currentDayName = LocalDate.now().dayOfWeek.name
    val temperature = (loadedUiState.currentWeather.weatherMain.weatherTemperature - 273)
    val currentWeatherStatus =
        loadedUiState.currentWeather.currentWeather.firstOrNull()?.weatherMain.orEmpty()

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
                humidity = loadedUiState.currentWeather.weatherMain.weatherHumidity,
                windSpeed = loadedUiState.currentWeather.weatherWindInfo.windSpeed,
                pressure = loadedUiState.currentWeather.weatherMain.weatherPressure,
            )
            WeatherForecastBlock(
                loadedUiState = loadedUiState,
                onNavigateToMore = onNavigateToMore,
            )
        }
    }
}

@Composable
fun WeatherForecastBlock(
    loadedUiState: MainScreenUiState.Success,
    modifier: Modifier = Modifier,
    onNavigateToMore: () -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "В этод день",
                color = Color.White,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = dp12, top = dp8)
            )
            IconButton(
                onClick = { onNavigateToMore() },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.more_svgrepo_com),
                    contentDescription = null,
                    tint = Color.White,
                )
            }
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(dp8),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dp12)
        ) {
            items(
                loadedUiState.weatherDayInHours.list
            ) { forecast ->
                WeatherItem(loadedUiState = forecast)
            }
        }
    }
}

@Composable
fun WeatherStateLottie(
    loadedUiState: MainScreenUiState.Success,
    modifier: Modifier = Modifier,
) {
    loadedUiState.currentWeather.currentWeather.firstOrNull()?.apply {
        if (isClear) {
            WeatherLottieAnimation(
                modifier = modifier,
                rawFile = R.raw.sunny
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