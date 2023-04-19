package com.example.freedomsample.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.freedomsample.NavigationGraph
import com.example.freedomsample.Screen
import com.example.freedomsample.navigation.Router
import kotlinx.coroutines.delay

fun NavGraphBuilder.splashNavGraph(
    router: Router,
) {
    navigation(
        route = NavigationGraph.Splash.route,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(
                onResult = { route ->
                    router.routeTo(screen = route)
                }
            )
        }
    }
}

@Composable
fun SplashScreen(
    onResult: (String) -> Unit
) {
    LaunchedEffect(Unit) {
        delay(500)
        onResult.invoke(NavigationGraph.Auth.route)
    }
}