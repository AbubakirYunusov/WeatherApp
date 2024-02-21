package com.example.weatherapp.presentation.screen.scren_home

import android.annotation.SuppressLint
import androidx.activity.addCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.weatherapp.presentation.components.WeatherTopAppBar
import com.example.weatherapp.presentation.components.common.ErrorScreen
import com.example.weatherapp.presentation.components.common.LoadingScreen
import com.example.weatherapp.presentation.components.common.NoConnectionScreen
import com.example.weatherapp.presentation.screen.scren_home.component.LoadedWeatherScreens
import com.example.weatherapp.presentation.theme.BackgroundDefaultLight
import com.example.weatherapp.presentation.theme.BackgroundLight
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.flow.StateFlow

@Composable
fun MainScreen(
    uiStateFlow: StateFlow<MainScreenUiState>,
    getCurrentWeather: () -> Unit,
    onBackPressedCallBack: () -> Unit,
    onNavigateToMore: () -> Unit,
) {

    val darkTheme: Boolean = isSystemInDarkTheme()
    val systemUiController = rememberSystemUiController()

    val backgroundApp = if (darkTheme) BackgroundDefaultLight
    else BackgroundDefaultLight

    when (val mainUiStateUiFlow = uiStateFlow.collectAsState().value) {
        is MainScreenUiState.Loading -> LoadingScreen()
        is MainScreenUiState.Success -> {
            LoadedMainScreen(
                uiState = mainUiStateUiFlow,
                onBackPressedCallBack = onBackPressedCallBack,
                onNavigateToMore = onNavigateToMore,
            )
        }

        is MainScreenUiState.Error -> if (mainUiStateUiFlow.isErrorWithConnection) NoConnectionScreen(
            getCurrentWeather
        )
        else ErrorScreen(
            tryAgainCallback = getCurrentWeather, massage = mainUiStateUiFlow.massage
        )
    }

    SideEffect {
        systemUiController.setStatusBarColor(backgroundApp)
        systemUiController.setNavigationBarColor(backgroundApp)
    }

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoadedMainScreen(
    uiState: MainScreenUiState.Success,
    onBackPressedCallBack: () -> Unit,
    onNavigateToMore: () -> Unit,
) {

    val systemUiController = rememberSystemUiController()
    val colorBackground = MaterialTheme.colorScheme.background

    val backStackDispatcher = LocalOnBackPressedDispatcherOwner.current
    backStackDispatcher?.onBackPressedDispatcher?.addCallback {
        onBackPressedCallBack()
    }

    Scaffold(
        containerColor = BackgroundLight,
        topBar = { WeatherTopAppBar() }
    ) { innerPadding ->

        LoadedWeatherScreens(
            loadedUiState = uiState,
            modifier = Modifier.padding(innerPadding),
            onNavigateToMore = onNavigateToMore
        )
    }

    SideEffect {
        systemUiController.setStatusBarColor(colorBackground)
        systemUiController.setNavigationBarColor(colorBackground)
    }

}