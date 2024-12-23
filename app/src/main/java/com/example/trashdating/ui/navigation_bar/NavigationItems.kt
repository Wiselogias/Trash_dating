package com.example.trashdating.ui.navigation_bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val icon: ImageVector,
    val route: String,
)

object NavigationConstants {
    val BottomNavItems = listOf(
        BottomNavItem(
            icon = Icons.Filled.Home,
            route = "home"
        ),
        BottomNavItem(
            icon = Icons.Filled.Search,
            route = "explore"
        ),
        BottomNavItem(
            icon = Icons.Filled.Person,
            route = "profile"
        ),
        BottomNavItem(
            icon = Icons.Filled.MailOutline,
            route = "chat"
        ),
        BottomNavItem(
            icon = Icons.Filled.Person,
            route = "matches"
        )
    )
}