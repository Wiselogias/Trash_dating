package com.example.trashdating.ui.navigation_bar

import com.example.trashdating.R

data class BottomNavItem(
    val icon: Int,
    val route: String,
)

object NavigationConstants {
    val BottomNavItems = listOf(
        BottomNavItem(
            icon = R.drawable.ic_home_24,
            route = "home"
        ),
        BottomNavItem(
            icon = R.drawable.ic_search_24,
            route = "explore"
        ),
        BottomNavItem(
            icon = R.drawable.ic_group_24,
            route = "profile"
        ),
        BottomNavItem(
            icon = R.drawable.ic_chat_24,
            route = "chat"
        ),
        BottomNavItem(
            icon = R.drawable.ic_group_24,
            route = "matches"
        )
    )
}