package com.example.freedomsample.chats

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
import com.example.freedomsample.tabs.model.BottomBarScreen
import kotlin.random.Random

fun NavGraphBuilder.chatsScreen(
    hostNavController: NavHostController,
) {
    composable(route = BottomBarScreen.Chats.route) {
        ChatsScreen(
            onChatDetailClicked = { chatId ->
                hostNavController.navigateToChatDetail(chatId)
            }
        )
    }
}

@Composable
fun ChatsScreen(
    onChatDetailClicked: (String) -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(text = "chats screen")
            TextButton(
                modifier = Modifier,
                onClick = { onChatDetailClicked.invoke(Random.nextInt().toString()) }
            ) {
                Text("Show chat detail screen")
            }
        }
    }
}