package com.example.freedomsample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.core.util.Consumer
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.freedomsample.auth.authNavGraph
import com.example.freedomsample.chats.chatDetailScreen
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
                    // Host nav controller, used for showing full screen screens
                    val navController = rememberNavController()

                    DisposableEffect(Unit) {
                        val listener = Consumer<Intent> { intent ->
                            navController.handleDeepLink(intent)
                        }
                        addOnNewIntentListener(listener)
                        onDispose { removeOnNewIntentListener(listener) }
                    }

                    NavHost(
                        navController = navController,
                        startDestination = splashGraphRoute,
                        route = rootGraphRoute
                    ) {
                        splashNavGraph(navController)
                        authNavGraph(navController)
                        tabsScreen(navController)
                        chatDetailScreen(navController)
                    }
                }
            }
        }
    }
}