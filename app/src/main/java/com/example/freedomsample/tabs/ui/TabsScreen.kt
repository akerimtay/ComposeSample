package com.example.freedomsample.tabs.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.freedomsample.chats.chatsScreen
import com.example.freedomsample.expenses.expensesScreen
import com.example.freedomsample.payments.paymentsScreen
import com.example.freedomsample.product.productsScreen
import com.example.freedomsample.tabs.BottomBar
import com.example.freedomsample.tabs.model.BottomBarScreen

const val tabsGraphRoute = "graph_tabs"

fun NavGraphBuilder.tabsScreen(
    hostNavController: NavHostController,
) {
    composable(route = tabsGraphRoute) {
        TabsScreen(hostNavController = hostNavController)
    }
}

@Composable
fun TabsScreen(
    hostNavController: NavHostController,
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = BottomBarScreen.Products.route,
        ) {
            productsScreen()
            paymentsScreen()
            expensesScreen()
            chatsScreen(hostNavController = hostNavController)
        }
    }
}