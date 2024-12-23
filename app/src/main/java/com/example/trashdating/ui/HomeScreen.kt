package com.example.trashdating.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trashdating.R
import com.example.trashdating.ui.theme.Orange
import com.example.trashdating.ui.theme.TrashDatingTheme

@Composable
fun HomeScreen(
    onFollowedPeopleClick: (Profile) -> Unit,
    onCreateStoryClick: () -> Unit,
    onRelationshipTypeChanged: () -> Unit,
    followed: List<Profile>,
    profiles: List<Profile>
) {
    TrashDatingTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header()
            Stories(onCreateStoryClick, onFollowedPeopleClick, followed)
            RelationshipTypeSwitch(onRelationshipTypeChanged)
            ProfilesList(profiles)
        }
    }
}

@Composable
private fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp, start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
            Text(
                text = stringResource(R.string.iskra)
            )
        }
        Icon(imageVector = Icons.Default.Notifications, contentDescription = "Notifications")
    }
}

@Composable
private fun Stories(
    onCreateStoryClick: () -> Unit,
    onFollowedPeopleClick: (Profile) -> Unit,
    followed: List<Profile>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        FloatingActionButton(
            onClick = onCreateStoryClick,
            shape = ShapeDefaults.ExtraLarge,
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "+")
        }
        FollowedPeopleList(onFollowedPeopleClick, followed)
    }
}

@Composable
private fun FollowedPeopleList(onFollowedPeopleClick: (Profile) -> Unit, followed: List<Profile>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        state = rememberLazyListState()
    ) {
        items(items = followed) { person ->
            FollowedPeopleListItem(person, onFollowedPeopleClick)
        }
    }
}

@Composable
private fun FollowedPeopleListItem(person: Profile, onFollowedPeopleClick: (Profile) -> Unit) {
    Card(
        modifier = Modifier
            .size(56.dp)
            .clickable { onFollowedPeopleClick(person) },
        shape = CircleShape
    ) {
        Image(
            painterResource(R.drawable.ic_following_example),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .border(2.dp, Color(0xFFED760E), CircleShape)
        )
    }
}

@Composable
private fun RelationshipTypeSwitch(onRelationshipTypeChanged: () -> Unit) {
    var isFindFriend by remember { mutableStateOf(true) }
    Surface(
        color = Orange,
        shape = MaterialTheme.shapes.large
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(horizontal = 5.dp)
        ) {
            Button(
                onClick = {
                    onRelationshipTypeChanged()
                    isFindFriend = !isFindFriend
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isFindFriend) Color.White else Orange,
                    contentColor = Color.Black
                )
            ) {
                Text(
                    text = stringResource(id = R.string.home_screen_find_friend),
                    color = Color.Black,
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Button(
                onClick = {
                    onRelationshipTypeChanged()
                    isFindFriend = !isFindFriend
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (!isFindFriend) Color.White else Orange,
                    contentColor = Color.Black
                )
            ) {
                Text(
                    text = stringResource(R.string.home_screen_find_relations),
                    color = Color.Black,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
private fun ProfilesList(profiles: List<Profile>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(items = profiles) { profile ->
            ProfileListItem(profile)
        }
    }
}

@Composable
private fun ProfileListItem(profile: Profile) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .size(250.dp)
            .clickable {}
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_profile_back_example),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
            )

            Text(
                text = "hobby",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 16.dp, start = 16.dp)
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "quote",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = profile.name,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 8.dp, end = 8.dp)
            ) {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.like),
                        contentDescription = "Like",
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .size(12.dp)
                    )
                   Icon(
                        painter = painterResource(id = R.drawable.write),
                        contentDescription = "Message",
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .size(12.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.more),
                        contentDescription = "Options",
                        modifier = Modifier.size(12.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HomeScreen(
        onFollowedPeopleClick = {},
        onCreateStoryClick = {},
        onRelationshipTypeChanged = {},
        followed = listOf(Profile("Clare", "clare@gmail.com", "Pup")),
        profiles = listOf(Profile("Alice", "alice@example.com", "Profile picture"))
    )
}

data class Profile(val name: String, val email: String, val imageUrl: String)