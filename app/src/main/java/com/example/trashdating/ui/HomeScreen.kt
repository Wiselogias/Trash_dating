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
import com.example.trashdating.R
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
        Text(text = stringResource(R.string.iskra), fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Notifications"
        )
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
            shape = ShapeDefaults.ExtraLarge,
            onClick = onCreateStoryClick,
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = stringResource(R.string.plus))
        }
        FollowedPeopleList(onFollowedPeopleClick, followed)
    }
}

@Composable
    Box(
    ) {
        Text(
        )
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