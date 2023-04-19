package com.example.freedomsample.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.freedomsample.NavigationGraph
import com.example.freedomsample.Screen
import com.example.freedomsample.navigation.Router

fun NavGraphBuilder.authNavGraph(
    router: Router,
    navController: NavController,
) {
    navigation(
        route = NavigationGraph.Auth.route,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(
                navigateToConfirm = {
                    navController.navigate(Screen.Confirm.route)
                }
            )
        }
        composable(Screen.Confirm.route) {
            ConfirmScreen(
                onSignIn = {
                    router.routeTo(NavigationGraph.Tabs.route)
                }
            )
        }
    }
}

@Composable
fun LoginScreen(
    navigateToConfirm: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text("Login Screen")
            TextButton(
                modifier = Modifier,
                onClick = { navigateToConfirm.invoke() }
            ) {
                Text("Show Login Verify Screen")
            }
        }
    }
}

@Composable
fun ConfirmScreen(
    onSignIn: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text("Confirm Screen")
            TextButton(
                modifier = Modifier,
                onClick = { onSignIn.invoke() }
            ) {
                Text("Show Main Screen")
            }
        }
    }
}