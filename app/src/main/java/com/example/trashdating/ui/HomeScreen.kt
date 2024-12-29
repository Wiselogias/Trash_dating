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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.trashdating.R
import com.example.trashdating.model.Profile
import com.example.trashdating.ui.theme.Orange
import com.example.trashdating.ui.theme.TrashDatingTheme
import com.example.trashdating.ui.theme.White
import com.example.trashdating.viewmodel.ProfilesViewModel
import com.example.trashdating.viewmodel.ProfilesViewModelMock

@Composable
fun HomeScreen(
    onFollowedPeopleClick: (Profile) -> Unit,
    onCreateStoryClick: () -> Unit,
    onRelationshipTypeChanged: () -> Unit,
    viewModel: ProfilesViewModel,
) {
    TrashDatingTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header()
            Stories(onCreateStoryClick, onFollowedPeopleClick, viewModel.followed)
            RelationshipTypeSwitch(onRelationshipTypeChanged)
            ProfilesList(viewModel)
        }
    }
}

@Composable
private fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp, start = 8.dp, end = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .size(35.dp)
                    .padding(end = 4.dp)
            )
            Image(
                painter = painterResource(R.drawable.app_name),
                contentDescription = null,
                modifier = Modifier.height(35.dp)
            )
        }
        Image(
            painter = painterResource(R.drawable.notification_bell),
            contentDescription = "Notifications",
            modifier = Modifier.size(35.dp),
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
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = onCreateStoryClick,
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(containerColor = White),
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .size(56.dp)
                .border(2.dp, Orange, CircleShape)
        ) {
            Text(
                text = "+",
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                color = Orange
            )
        }
        FollowedPeopleList(onFollowedPeopleClick, followed)
    }
}

@Composable
private fun FollowedPeopleList(onFollowedPeopleClick: (Profile) -> Unit, followed: List<Profile>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
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
        modifier = Modifier.size(56.dp),
        shape = CircleShape
    ) {
        AsyncImage(
            model = person.avatar,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .border(2.dp, Orange, CircleShape)
                .clickable { onFollowedPeopleClick(person) }
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
                ),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    text = stringResource(id = R.string.home_screen_find_friend),
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 16.sp
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
                ),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    text = stringResource(R.string.home_screen_find_relations),
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
private fun ProfilesList(viewModel: ProfilesViewModel) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items = viewModel.profiles) { profile ->
            ProfileListItem(profile, viewModel)
        }
    }
}

@Composable
private fun ProfileListItem(profile: Profile, viewModel: ProfilesViewModel) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .clickable {}
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AsyncImage(
                model = profile.profileImage,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Row(
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp)
                    .align(Alignment.TopStart)
            ) {
                Image(
                    painter = painterResource(profile.hobby.sticker),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 4.dp)
                )
                Text(
                    text = profile.hobby.name,
                    style = MaterialTheme.typography.labelLarge,
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    color = White
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = viewModel.getQuote(profile.id),
                    style = MaterialTheme.typography.bodyMedium,
                    color = White
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = profile.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = White
                )
            }

            Column(
                modifier = Modifier
                    .width(45.dp)
                    .align(Alignment.TopEnd)
                    .padding(top = 8.dp, end = 8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.like),
                    contentDescription = "Like",
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth()
                        .height(45.dp),
                    tint = White
                )
               Icon(
                    painter = painterResource(id = R.drawable.write),
                    contentDescription = "Message",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp),
                    tint = White
               )
                Icon(
                    painter = painterResource(id = R.drawable.more),
                    contentDescription = "Options",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp),
                    tint = White
                )
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
        viewModel = ProfilesViewModelMock
    )
}
