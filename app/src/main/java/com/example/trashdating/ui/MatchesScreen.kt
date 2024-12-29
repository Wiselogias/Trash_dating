package com.example.trashdating.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
fun MatchesScreen(
    onLikedPeopleClick: () -> Unit,
    onChattedPeopleClick: () -> Unit,
    onPersonProfileClick: () -> Unit,
    viewModel: ProfilesViewModel,
) {
    TrashDatingTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header()
            LikesAndChats(onLikedPeopleClick, onChattedPeopleClick, viewModel.likes, viewModel.messages)
            MatchedProfilesList(onPersonProfileClick, viewModel.matches)
        }
    }
}

@Composable
private fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp, start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier.size(38.dp),
            shape = CircleShape,
            border = BorderStroke(1.dp, Orange),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainer
            )
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "Back",
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {}
                    .padding(8.dp)
            )
        }
        Text(
            text = stringResource(R.string.matches_screen_header),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Card(
            modifier = Modifier.size(38.dp),
            shape = CircleShape,
            border = BorderStroke(1.dp, Orange),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainer
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.options),
                contentDescription = "Notifications",
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {}
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun LikesAndChats(
    onLikedPeopleClick: () -> Unit,
    onChattedPeopleClick: () -> Unit,
    liked: Int,
    messages: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.size(56.dp),
                shape = CircleShape,
                border = BorderStroke(2.dp, Orange),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainer
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Likes",
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable { onLikedPeopleClick() }
                        .padding(10.dp)
                )
            }
            Row {
                Text(
                    text = stringResource(R.string.matches_screen_likes),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(
                    text = liked.toString(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Orange
                )
            }
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.size(56.dp),
                shape = CircleShape,
                border = BorderStroke(2.dp, Orange),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainer
                )
            ) {
                Icon(
                    painter = painterResource(R.drawable.messages),
                    contentDescription = "Messages",
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable { onChattedPeopleClick() }
                        .padding(10.dp)
                )
            }
            Row {
                Text(
                    text = stringResource(R.string.matches_screen_messages),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(
                    text = messages.toString(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Orange
                )
            }
        }
    }
}

@Composable
fun MatchedProfilesList(onPersonProfileClick: () -> Unit, profiles: List<Profile>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.matches_srceen_total_matches),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(
                text = profiles.size.toString(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Orange
            )
        }
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
        ) {
            itemsIndexed(profiles) { _, profile ->
                Card(
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(200.dp)
                        .border(3.dp, Orange, MaterialTheme.shapes.medium)
                ) {
                    Box(modifier = Modifier.clickable { onPersonProfileClick() }) {
                        AsyncImage(
                            model = profile.avatar,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        Card (
                            modifier = Modifier
                                .align(Alignment.TopCenter)
                                .width(100.dp),
                            colors = CardDefaults.cardColors(containerColor = Orange),
                            shape = RoundedCornerShape(
                                bottomEndPercent = 40,
                                bottomStartPercent = 40
                            )
                        ) {
                            Text(
                                text = stringResource(
                                    R.string.match_screen_match_percent,
                                    profile.matchPercent
                                ),
                                textAlign = TextAlign.Right,
                                color = White,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp,
                                modifier = Modifier.padding(horizontal = 5.dp)
                                    .align(Alignment.CenterHorizontally)
                            )
                        }
                        Text(
                            text = profile.name,
                            color = Color.White,
                            fontSize = 24.sp,
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(bottom = 16.dp)
                        )
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun MatchesPreview() {
    MatchesScreen(
        onLikedPeopleClick = {},
        onChattedPeopleClick = {},
        onPersonProfileClick = {},
        viewModel = ProfilesViewModelMock
    )
}
