package com.example.freedomsample.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.freedomsample.auth.authGraphRoute
import com.example.freedomsample.navigation.Router
import kotlinx.coroutines.delay

const val splashGraphRoute = "graph_splash"
const val splashScreenRoute = "splash"

fun NavGraphBuilder.splashNavGraph(
    router: Router,
) {
    navigation(
        route = splashGraphRoute,
        startDestination = splashScreenRoute,
    ) {
        composable(splashScreenRoute) {
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
        onResult.invoke(authGraphRoute)
    }
}