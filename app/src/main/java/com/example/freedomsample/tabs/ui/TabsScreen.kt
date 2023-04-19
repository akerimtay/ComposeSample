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
import com.example.freedomsample.NavigationGraph
import com.example.freedomsample.chats.chatsScreen
import com.example.freedomsample.expenses.expensesScreen
import com.example.freedomsample.navigation.Router
import com.example.freedomsample.payments.paymentsScreen
import com.example.freedomsample.product.productsScreen
import com.example.freedomsample.tabs.BottomBar
import com.example.freedomsample.tabs.model.BottomBarScreen

fun NavGraphBuilder.tabsScreen(
    router: Router
) {
    composable(route = NavigationGraph.Tabs.route) {
        TabsScreen(router = router)
    }
}

@Composable
fun TabsScreen(
    router: Router
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) { innerPadding ->
        TabsNavGraph(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            router = router,
        )
    }
}

@Composable
fun TabsNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    router: Router,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = BottomBarScreen.Products.route,
    ) {
        productsScreen(router = router)
        paymentsScreen(router = router)
        expensesScreen(router = router)
        chatsScreen(router = router)
    }
}