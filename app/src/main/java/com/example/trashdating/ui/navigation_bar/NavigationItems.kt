package com.example.trashdating.ui.navigation_bar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import com.example.trashdating.R

data class BottomNavItem(
    val icon: @Composable (() -> Unit),
    val route: String,
)

object NavigationConstants {
    val BottomNavItems = listOf(
        BottomNavItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home_24),
                    contentDescription = "Home"
                )
            },
            route = "home"
        ),
        BottomNavItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search_24),
                    contentDescription = "Explore"
                )
            },
            route = "explore"
        ),
        BottomNavItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.profile_photo),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color(0xFFFF9401), CircleShape),
                    contentScale = ContentScale.Crop
                )
            },
            route = "profile"
        ),
        BottomNavItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_chat_24),
                    contentDescription = "Chat"
                )
            },
            route = "chat"
        ),
        BottomNavItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_group_24),
                    contentDescription = "Matches"
                )
            },
            route = "matches"
        )
    )
}
