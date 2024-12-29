package com.example.trashdating.ui


import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.trashdating.R
import com.example.trashdating.viewmodel.ProfileCardViewModel


@Composable
fun ProfileScreen(
    viewModel: ProfileCardViewModel
) {
    val profile = remember { viewModel.authorizedUserData }
    var sheetOffset by remember { mutableStateOf(500.dp) }
    val animatedOffset by animateDpAsState(targetValue = sheetOffset)
    var heartColorButton by remember { mutableStateOf(Color(0xFFABB0BA))}


    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        ProfileBackgroundInformation(
            profile.name,
            profile.age,
            profile.city,
            profile.matchprocent,
            profile.profileImage
        )
        Header(profile.distance)
        DraggableSheet(
            tagsEats = profile.tags.eats,
            tagsSocials = profile.tags.socials,
            tagsArts = profile.tags.arts,
            tagsLife = profile.tags.life,
            sheetOffset = animatedOffset,
            onDrag = { dragAmount ->
                sheetOffset = (sheetOffset + dragAmount.dp).coerceIn(0.dp, 500.dp)
            }
        )
        ProfileBotomBar(
            heartColor = heartColorButton,
            onHeartClick = {
                heartColorButton = if (heartColorButton == Color(0xFFABB0BA))
                    Color(0xFFF55231)
                else
                    Color(0xFFABB0BA)
            },
            onStarClick = {},
            onCrossClick = {},
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        )

    }
    LaunchedEffect(sheetOffset) {

        if (sheetOffset == 0.dp || sheetOffset == 500.dp) return@LaunchedEffect
        if (sheetOffset < 250.dp) {
            sheetOffset = 0.dp
        } else{
            sheetOffset = 500.dp
        }
    }
}

@Composable
fun Header (distance: Float) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = WindowInsets.statusBars
                    .asPaddingValues()
                    .calculateTopPadding()
            )
            .height(60.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            onClick = {

            },
            modifier = Modifier
                .clip(CircleShape)
                .border(1.dp, shape = CircleShape, color = Color(0xFFFFDDAE))
        ) {
            Icon(
                painter = painterResource(id = R.drawable.back),
                contentDescription = "back",
                tint = Color(0xFFFFDDAE)
            )
        }
        Text(
            text = "$distance km",
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier
                .border(1.dp, Color(0xFFFACC7A), shape = RoundedCornerShape(16.dp))
                .padding(horizontal = 10.dp, vertical = 2.dp)
                .wrapContentWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ProfileBackgroundInformation(
    name: String,
    age: Int,
    city: String,
    matchprocent: Int,
    profileImage: String
){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        AsyncImage(
            model = profileImage,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )



        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = "$name, $age",
                fontSize = 36.sp,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .padding(bottom = 12.dp)
            )
            Text(
                text = city.uppercase(),
                modifier = Modifier
                    .padding(bottom = 12.dp)
                    .alpha(0.8f),
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,

                )
            Box(

                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp)
                    .padding()
                    .clip(
                        CircleShape
                    )
                    .background(Color(0xFFFFDDAE))
                    .padding(all = 2.dp)
                    .clip(
                        CircleShape
                    )
                    .background(Color(0xFFFF9401))


            ) {
                Text(
                    text = "$matchprocent% Совпадение",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .align(Alignment.Center)

                )
            }


        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProfileTagsSection(title: String, tags: List<String>) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Text(
            text = title,
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.inverseSurface,
            modifier = Modifier.padding(horizontal = 4.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(horizontal = 4.dp)
        ) {
            tags.forEach { tag ->
                Text(
                    text = tag,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.inverseSurface,
                    modifier = Modifier
                        .border(1.dp, Color(0xFFFACC7A), shape = RoundedCornerShape(16.dp))
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                )
            }
        }
    }
}

@Composable
fun DraggableSheet(
    tagsEats: List<String>,
    tagsSocials: List<String>,
    tagsArts: List<String>,
    tagsLife: List<String>,
    sheetOffset: Dp,
    onDrag: (Float) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .offset { IntOffset(0, sheetOffset.roundToPx()) }
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
            )
            .pointerInput(Unit) {
                detectVerticalDragGestures { _, dragAmount ->
                    onDrag(dragAmount)
                }
            }
            .fillMaxHeight(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Box(
                modifier = Modifier
                    .width(60.dp)
                    .height(4.dp)
                    .background(Color.LightGray, shape = RoundedCornerShape(2.dp))
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))

            ProfileTagsSection("Еда и напитки", tagsEats)
            ProfileTagsSection("Социальная жизнь", tagsSocials)
            ProfileTagsSection("Творчество", tagsArts)
            ProfileTagsSection("Активный образ жизни", tagsLife)
        }
    }
}


@Composable
fun ProfileBotomBar(
    heartColor: Color,
    onHeartClick: (Color) -> Unit,
    onStarClick: () -> Unit,
    onCrossClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier

    ) {
        Box(
            modifier = Modifier
                .height(80.dp)
                .width(200.dp)
                .padding(bottom = 16.dp)
                .shadow(4.dp, shape = CircleShape)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surfaceContainerHigh),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onStarClick,
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color(0xFFFF9401))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = "Star",
                        tint = Color.White
                    )
                }

                IconButton(
                    onClick = { onHeartClick(heartColor) },
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(heartColor)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.heart),
                        contentDescription = "Heart",
                        tint = Color.White
                    )
                }

                IconButton(
                    onClick = onCrossClick,
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.White)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.x),
                        contentDescription = "Cross",
                        tint = Color.Black
                    )
                }
            }
        }
    }
}






