package com.example.trashdating.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.AbsoluteAlignment.CenterRight
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import androidx.compose.ui.res.painterResource
import com.example.trashdating.R

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProfileScreen(
    //imageUrl: String,
    name: String,
    city: String,
    age: Int,
    distance: Float
) {
    val tagseats = remember { listOf("Пицца", "Суши", "Бургеры", "Кофе") }
    val tagsocials = remember { listOf("Кинотеатры", "Концерты и шоу", "Музеи и галлереи", "Театры", "Шоппинг") }
    val tagarts = remember { listOf("Фотография", "Видеосъемка", "Дизайн", "Танцы") }
    val taglifes = remember { listOf("Бег", "Фитнес", "Велосипед", "Лыжи", "Йога", "Сноуборд") }
    var sheetOffset by remember { mutableStateOf(500.dp) }
    val animatedOffset by animateDpAsState(targetValue = sheetOffset)
    var heartColorButton by remember { mutableStateOf(Color(0xFFABB0BA))}
    val km: Float = 2.5f

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.adrian),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .height(60.dp)
                .padding(all = 16.dp),




            ) {
            IconButton(
                onClick = {

                },
                modifier = Modifier
                    .clip(CircleShape)
                    .border(1.dp,shape = CircleShape,  color = Color(0xFFFFDDAE))
                    .align(Alignment.TopStart)

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "back",
                    tint = Color(0xFFFFDDAE)
                )
            }
            Text(
                text = "$distance km",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier

                    .border(1.dp, Color(0xFFFACC7A), shape = RoundedCornerShape(16.dp))
                    .padding(horizontal = 10.dp, vertical = 2.dp)
                    .wrapContentWidth()
                    .align(Alignment.TopEnd),
                textAlign = TextAlign.Center

            )
        }

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



            ){
                Text(
                    text = "80% Совпадение",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .align(Alignment.Center)

                )
            }


        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset { IntOffset(0, animatedOffset.roundToPx()) }
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                )
                .pointerInput(Unit) {
                    detectVerticalDragGestures { _, dragAmount ->
                        sheetOffset = (sheetOffset + dragAmount.dp).coerceIn(0.dp, 500.dp)
                    }
                }
                .fillMaxHeight()
            ,
            contentAlignment = Alignment.TopCenter
        )

        {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(60.dp)
                        .height(4.dp)
                        .background(Color.LightGray, shape = RoundedCornerShape(2.dp))
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Обо мне",
                    fontSize = 18.sp,
                    color = Color(0xFF828282),
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Сын маминой подруги",
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Еда и напитки",
                    fontSize = 18.sp,
                    color = Color(0xFF828282),
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))
                // Tags
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(
                        horizontal = 4.dp,
                    ),
                ) {
                    tagseats.forEach { tag ->
                        Text(
                            text = tag,
                            fontSize = 18.sp,
                            color = Color.Black,
                            modifier = Modifier
                                .border(1.dp, Color(0xFFFACC7A), shape = RoundedCornerShape(16.dp))
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Социальная жизнь",
                    fontSize = 18.sp,
                    color = Color(0xFF828282),
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(
                        horizontal = 4.dp,
                    ),
                ) {
                    tagsocials.forEach { tag ->
                        Text(
                            text = tag,
                            fontSize = 18.sp,
                            color = Color.Black,
                            modifier = Modifier
                                .border(1.dp, Color(0xFFFACC7A), shape = RoundedCornerShape(16.dp))
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Творчество",
                    fontSize = 18.sp,
                    color = Color(0xFF828282),
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(
                        horizontal = 4.dp,
                    ),
                ) {
                    tagarts.forEach { tag ->
                        Text(
                            text = tag,
                            fontSize = 18.sp,
                            color = Color.Black,
                            modifier = Modifier
                                .border(1.dp, Color(0xFFFACC7A), shape = RoundedCornerShape(16.dp))
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Активный образ жизни",
                    fontSize = 18.sp,
                    color = Color(0xFF828282),
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(
                        horizontal = 4.dp,
                    ),
                ) {
                    taglifes.forEach { tag ->
                        Text(
                            text = tag,
                            fontSize = 18.sp,
                            color = Color.Black,
                            modifier = Modifier
                                .border(1.dp, Color(0xFFFACC7A), shape = RoundedCornerShape(16.dp))
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                        )
                    }
                }


            }
        }
        Box(
            modifier = Modifier

                .height(80.dp)
                .width(200.dp)
                .padding(bottom = 16.dp)
                .shadow(4.dp, shape = CircleShape)
                .clip(CircleShape)
                .background(Color.White)
                .align(Alignment.BottomCenter)
            ,


            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = {

                    },
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
                    onClick = {
                        heartColorButton = if (heartColorButton == Color(0xFFABB0BA))
                            Color(0xFFF55231)
                        else Color (0xFFABB0BA)

                    },
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(heartColorButton)
                ) {


                    Icon(
                        painter = painterResource(id = R.drawable.heart),
                        contentDescription = "Heart",
                        tint = Color.White
                    )
                }

                IconButton(
                    onClick = {

                    },
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
    LaunchedEffect(sheetOffset) {

        if (sheetOffset == 0.dp || sheetOffset == 500.dp) return@LaunchedEffect
        if (sheetOffset < 250.dp) {
            sheetOffset = 0.dp
        } else{
            sheetOffset = 500.dp
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MatchScreenBar() {
    var heartColorButton by remember { mutableStateOf(Color(0xFFABB0BA))}

    Box(
        modifier = Modifier

            .height(80.dp)
            .width(200.dp)
            .padding(bottom = 16.dp)
            .shadow(4.dp, shape = CircleShape)
            .clip(CircleShape)
            .background(Color.White)
        //.align(Alignment.BottomCenter)
        ,


        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = {

                },
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
                onClick = {
                    heartColorButton = if (heartColorButton == Color(0xFFABB0BA))
                        Color(0xFFF55231)
                    else Color (0xFFABB0BA)

                },
                modifier = Modifier
                    .clip(CircleShape)
                    .background(heartColorButton)
            ) {


                Icon(
                    painter = painterResource(id = R.drawable.heart),
                    contentDescription = "Heart",
                    tint = Color.White
                )
            }

            IconButton(
                onClick = {

                },
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
