package com.example.trashdating.ui.navigation_bar

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.trashdating.ui.ChatScreen
import com.example.trashdating.ui.ExploreScreen
import com.example.trashdating.ui.HomeScreen
import com.example.trashdating.ui.MatchesScreen
import com.example.trashdating.ui.ProfileScreen

@Composable
fun NavHostContainer(
    navController: NavHostController,
    padding: PaddingValues
) {

    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = Modifier.padding(paddingValues = padding),
        builder = {
            composable("chat") {
                ChatScreen()
            }

            composable("explore") {
                ExploreScreen()
            }

            composable("home") {
                HomeScreen()
            }

            composable("matches") {
                MatchesScreen()
            }

            composable("profile") {
                ProfileScreen()
            }
        })

}
