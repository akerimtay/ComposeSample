package com.example.freedomsample

sealed class NavigationGraph(val route: String) {
    object Root : NavigationGraph("graph_root")
    object Splash : NavigationGraph("graph_splash")
    object Auth : NavigationGraph("graph_auth")
    object Tabs : NavigationGraph("graph_tabs")
}

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Confirm : Screen("confirm")
}