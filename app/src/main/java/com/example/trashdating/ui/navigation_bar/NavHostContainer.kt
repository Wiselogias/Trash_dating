package com.example.trashdating.ui.navigation_bar

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.trashdating.model.Profile
import com.example.trashdating.repository.impl.QuotesRepositoryMock
import com.example.trashdating.repository.impl.UsersRepositoryMock
import com.example.trashdating.ui.ChatScreen
import com.example.trashdating.ui.ExploreScreen
import com.example.trashdating.ui.HomeScreen
import com.example.trashdating.ui.MatchesScreen
import com.example.trashdating.ui.ProfileScreen
import com.example.trashdating.viewmodel.ProfilesViewModel

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
                HomeScreen(
                    onFollowedPeopleClick = {},
                    onCreateStoryClick = {},
                    onRelationshipTypeChanged = {},
                    viewModel = ProfilesViewModel(
                        Profile(
                            name = "Tim",
                            email = "glhf@example.com",
                            avatar = "http://images.com/0",
                            hobby = "cooking",
                            profileImage = ""
                        ),
                        UsersRepositoryMock(),
                        QuotesRepositoryMock()
                    )
                )
            }

            composable("matches") {
                MatchesScreen(
                    onLikedPeopleClick = {},
                    onChattedPeopleClick = {},
                    onPersonProfileClick = {},
                    profiles = listOf(Profile("Clare", "clare@gmail.com", "Pup", "cooking", "")),
                    1,
                    2
                )
            }

            composable("profile") {
                ProfileScreen()
            }
        })

}
