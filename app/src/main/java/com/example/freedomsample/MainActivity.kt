package com.example.freedomsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.freedomsample.auth.authNavGraph
import com.example.freedomsample.navigation.createExternalRouter
import com.example.freedomsample.navigation.navigate
import com.example.freedomsample.splash.splashNavGraph
import com.example.freedomsample.tabs.ui.tabsScreen
import com.example.freedomsample.uikit.FreedomSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FreedomSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = NavigationGraph.Splash.route,
                        route = NavigationGraph.Root.route
                    ) {
                        val router = createExternalRouter { route, bundle ->
                            navController.navigate(
                                route = route,
                                params = bundle
                            ) {
                                popUpTo(NavigationGraph.Root.route)
                            }
                        }
                        splashNavGraph(router = router)
                        authNavGraph(
                            router = router,
                            navController = navController
                        )
                        tabsScreen(router = router)
                    }
                }
            }
        }
    }
}