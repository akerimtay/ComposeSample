package com.example.freedomsample.tabs.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Products : BottomBarScreen(
        route = "products",
        title = "Products",
        icon = Icons.Default.Home
    )

    object Payments : BottomBarScreen(
        route = "payments",
        title = "Payments",
        icon = Icons.Default.Person
    )

    object Expenses : BottomBarScreen(
        route = "expenses",
        title = "Expenses",
        icon = Icons.Default.Settings
    )

    object Chats : BottomBarScreen(
        route = "chats",
        title = "Chats",
        icon = Icons.Default.Add
    )
}