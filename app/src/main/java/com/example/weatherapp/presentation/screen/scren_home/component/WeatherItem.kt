package com.example.weatherapp.presentation.screen.scren_home.component

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.weatherapp.R
import com.example.weatherapp.presentation.models.models_for_fifteen_days.WeatherCloudUiModel
import com.example.weatherapp.presentation.screen.scren_home.MainScreenUiState
import com.example.weatherapp.presentation.theme.BackRoundBlueCardLightItem
import com.example.weatherapp.presentation.theme.BackRoundCardDefaultItem
import com.example.weatherapp.presentation.theme.dp10
import com.example.weatherapp.presentation.theme.dp20
import com.example.weatherapp.presentation.theme.dp57
import com.example.weatherapp.presentation.theme.dp8
import com.example.weatherapp.presentation.theme.dp86
import com.example.weatherapp.presentation.theme.sp12

@Composable
fun WeatherItem(
    modifier: Modifier = Modifier,
    loadedUiState: WeatherCloudUiModel
) {

    val time = loadedUiState.dtTxt.split(" ").get(1).split(":").take(2).joinToString(":")

    Card(
        modifier = modifier
            .width(dp57)
            .height(dp86), colors = CardDefaults.cardColors(
            if (isSystemInDarkTheme()) BackRoundBlueCardLightItem
            else BackRoundCardDefaultItem,
        ), shape = RoundedCornerShape(size = dp8)
    ) {
        Column {
            Text(
                modifier = modifier
                    .padding(horizontal = dp8)
                    .fillMaxWidth()
                    .padding(top = dp8),
                text = "$time",
                fontSize = sp12,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Light,
                color = Color.White,
            )
            Icon(
                modifier = modifier.padding(top = dp10, start = dp20),
                painter = painterResource(id = R.drawable.weather),
                contentDescription = null,
                tint = Color.White
            )
            Text(
                modifier = modifier
                    .padding(top = dp8)
                    .fillMaxWidth(),
                text = "${loadedUiState.main.temp.toInt().minus(273)}°",
                textAlign = TextAlign.Center,
                fontSize = sp12,
                fontWeight = FontWeight.Medium,
                color = Color.White,
            )
        }
    }
}