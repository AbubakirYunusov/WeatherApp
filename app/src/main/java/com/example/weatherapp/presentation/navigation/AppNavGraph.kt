package com.example.weatherapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.presentation.screen.scren_home.MainScreen
import com.example.weatherapp.presentation.screen.scren_home.MainScreenViewModel
import com.example.weatherapp.presentation.screen.scren_splash.SplashScreen

@Composable
fun AppNavGraph(
    onBackPressedCallBack: () -> Unit,
    onNavigateToMore: () -> Unit,
) {

    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.Splashscreen.route
    ) {

        composable(Screens.HomeScreen.route) {
            val viewModel: MainScreenViewModel = hiltViewModel()
            MainScreen(
                uiStateFlow = viewModel.uiState,
                onBackPressedCallBack = onBackPressedCallBack,
                getCurrentWeather = {},
                onNavigateToMore = {}
            )
        }
        composable(Screens.Splashscreen.route) {
            SplashScreen(
                onNavigateNext = {
                    navController.navigate(Screens.HomeScreen.route)
                }
            )
        }
    }
}