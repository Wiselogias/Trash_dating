package com.example.trashdating.ui.navigation_bar

import com.example.trashdating.R

sealed class BottomNavItem(open val route: String)

data class IconNavItem(
    val icon: Int,
    override val route : String
) : BottomNavItem(route)

data class ImageNavItem(
    val imageUrl: String,
    override val route: String
) : BottomNavItem(route)

object NavigationConstants {
    val BottomNavItems = listOf(
        IconNavItem(
            icon = R.drawable.ic_home_24,
            route = "home"
        ),
        IconNavItem(
            icon = R.drawable.ic_search_24,
            route = "explore"
        ),
        ImageNavItem(
            imageUrl = "https://sun9-50.userapi.com/impg/og_hN2eEY4_hEZayQS9hbVWbHz3gRdJwSGxTtQ/GAqDztiBJps.jpg?size=444x592&quality=95&sign=b555184b7a55d7809c21274460bb407c&type=album",
            route = "profile"
        ),
        IconNavItem(
            icon = R.drawable.ic_chat_24,
            route = "chat"
        ),
        IconNavItem(
            icon = R.drawable.ic_group_24,
            route = "matches"
        )
    )
}
