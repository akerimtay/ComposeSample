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
import com.example.freedomsample.chats.chatDetailScreen
import com.example.freedomsample.navigation.createExternalRouter
import com.example.freedomsample.splash.splashGraphRoute
import com.example.freedomsample.splash.splashNavGraph
import com.example.freedomsample.tabs.ui.tabsScreen
import com.example.freedomsample.uikit.FreedomSampleTheme

const val rootGraphRoute = "graph_root"

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
                        startDestination = splashGraphRoute,
                        route = rootGraphRoute
                    ) {
                        val router = createExternalRouter { route ->
                            navController.navigate(route = route) {
                                popUpTo(rootGraphRoute)
                            }
                        }
                        splashNavGraph(router = router)
                        authNavGraph(
                            router = router,
                            navController = navController
                        )
                        tabsScreen(hostNavController = navController)
                        chatDetailScreen(hostNavController = navController)
                    }
                }
            }
        }
    }
}