package com.example.weatherapp.presentation.components.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.presentation.components.WeatherLottieAnimation
import com.example.weatherapp.presentation.theme.WeatherBlue
import com.example.weatherapp.presentation.theme.dp16
import com.example.weatherapp.presentation.theme.sp22
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun NoConnectionScreen(
    tryAgainCallback: () -> Unit,
    modifier: Modifier = Modifier,
) {

    val systemUiController = rememberSystemUiController()
    val colorBackground = MaterialTheme.colorScheme.background

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            WeatherLottieAnimation(
                modifier = modifier.size(150.dp),
                rawFile = R.raw.no_internet_lottie,
            )
            Text(
                text = stringResource(id = R.string.no_connection),
                fontWeight = FontWeight.Medium,
                fontSize = sp22,
            )
            Button(
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = WeatherBlue
                ),
                onClick = {
                    tryAgainCallback()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dp16)
            ) {
                Text(text = stringResource(id = R.string.try_again))
            }
        }
    }
    SideEffect {
        systemUiController.setStatusBarColor(colorBackground)
        systemUiController.setNavigationBarColor(colorBackground)
    }
}


@Preview
@Composable
fun NoConnectionScreenPreview() {
    NoConnectionScreen(
        tryAgainCallback = {}
    )
}