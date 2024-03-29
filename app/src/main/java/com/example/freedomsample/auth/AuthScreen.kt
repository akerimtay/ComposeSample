package com.example.freedomsample.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.freedomsample.rootGraphRoute
import com.example.freedomsample.tabs.ui.tabsGraphRoute

const val authGraphRoute = "graph_auth"
const val loginScreenRoute = "login"
const val confirmScreenRoute = "confirm"

fun NavGraphBuilder.authNavGraph(
    hostNavController: NavHostController,
) {
    navigation(
        route = authGraphRoute,
        startDestination = loginScreenRoute,
    ) {
        composable(loginScreenRoute) {
            LoginScreen(
                navigateToConfirm = {
                    hostNavController.navigate(confirmScreenRoute)
                }
            )
        }
        composable(confirmScreenRoute) {
            ConfirmScreen(
                onSignIn = {
                    hostNavController.navigate(tabsGraphRoute) {
                        popUpTo(rootGraphRoute)
                    }
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