package com.example.freedomsample.payments

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.freedomsample.tabs.model.BottomBarScreen

fun NavGraphBuilder.paymentsScreen() {
    composable(route = BottomBarScreen.Payments.route) {
        PaymentsScreen()
    }
}

@Composable
fun PaymentsScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Payments")
    }
}