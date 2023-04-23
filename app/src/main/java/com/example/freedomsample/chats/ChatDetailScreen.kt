package com.example.freedomsample.chats

import android.net.Uri
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
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink

private const val baseUrl = "https://www.freedom.kz"

const val argChatId = "chat_id"
const val chatDetail = "chat_detail"
const val routeChatDetailScreen = "$chatDetail/{$argChatId}"

fun NavController.navigateToChatDetail(chatId: String) {
    val encodedId = Uri.encode(chatId)
    this.navigate("$chatDetail/$encodedId")
}

fun NavGraphBuilder.chatDetailScreen(
    hostNavController: NavHostController
) {
    composable(
        route = routeChatDetailScreen,
        arguments = listOf(
            navArgument(argChatId) { type = NavType.StringType },
        ),
        deepLinks = listOf(navDeepLink { uriPattern = "$baseUrl/{$argChatId}" })
    ) { backStackEntry ->
        val chatId = backStackEntry.arguments?.getString(argChatId)
            ?: throw IllegalArgumentException("You should pass $argChatId")
        ChatDetailScreen(
            chatId = chatId,
            onBackClicked = { hostNavController.navigateUp() }
        )
    }
}

@Composable
fun ChatDetailScreen(
    chatId: String,
    onBackClicked: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(text = "chat detail $chatId")
            TextButton(
                modifier = Modifier,
                onClick = { onBackClicked.invoke() }
            ) {
                Text("Go back")
            }
        }
    }
}