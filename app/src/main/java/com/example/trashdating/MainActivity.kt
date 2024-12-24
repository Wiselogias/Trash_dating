package com.example.trashdating

import BottomBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.trashdating.ui.navigation_bar.NavHostContainer
import com.example.trashdating.ui.theme.TrashDatingTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            TrashDatingTheme {
                val navController: NavHostController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        BottomBar(
                            navController = navController,
                            modifier = Modifier
                        )
                    }
                ) { paddingValues ->
                    Box(
                        modifier = Modifier
                    ) {
                        NavHostContainer(
                            navController = navController,
                            padding = paddingValues
                        )
                    }
                }
            }
        }
    }
}