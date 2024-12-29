package com.example.trashdating.ui

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trashdating.R
import com.example.trashdating.model.Profile
import com.example.trashdating.ui.theme.Orange
import com.example.trashdating.ui.theme.TrashDatingTheme

@Composable
fun MatchesScreen(
    onLikedPeopleClick: () -> Unit,
    onChattedPeopleClick: () -> Unit,
    onPersonProfileClick: () -> Unit,
    profiles: List<Profile>,
    liked: Int,
    messages: Int
) {
    TrashDatingTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header()
            LikesAndChats(onLikedPeopleClick, onChattedPeopleClick, liked, messages)
            MatchedProfilesList(onPersonProfileClick, profiles)
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
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
            contentDescription = "Back",
        )
        Text(
            text = stringResource(R.string.matches_screen_header),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Icon(
            painter = painterResource(id = R.drawable.options),
            contentDescription = "Notifications"
        )
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
                modifier = Modifier
                    .size(56.dp)
                    .clickable { onLikedPeopleClick() },
                shape = CircleShape,
                border = BorderStroke(2.dp, Orange)
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Likes",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
                )
            }
            Text(stringResource(R.string.matches_screen_likes, liked))
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .size(56.dp)
                    .clickable { onChattedPeopleClick() },
                shape = CircleShape,
                border = BorderStroke(2.dp, Orange)
            ) {
                Icon(
                    painter = painterResource(R.drawable.messages),
                    contentDescription = "Messages",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
                )
            }
            Text(stringResource(R.string.matches_screen_messages, messages))
        }
    }
}

@Composable
fun MatchedProfilesList(onPersonProfileClick: () -> Unit, profiles: List<Profile>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 8.dp)
    ) {
        Text(stringResource(R.string.matches_srceen_total_matches, profiles.size))
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
        ) {
            itemsIndexed(profiles) { _, item ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(200.dp)
                        .clickable { onPersonProfileClick() },
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = item.name,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontSize = 24.sp
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
        profiles = listOf(Profile("Clare", "clare@gmail.com", "Pup", "reading", "")),
        1,
        2
    )
}
