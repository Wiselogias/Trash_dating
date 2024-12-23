package com.example.trashdating.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


val Orange = Color(0xFFFF9F38)
val DarkGray = Color(0xFF1A1A1A)
val White = Color(0xFFFFFFFF)
val LightGray = Color(0xFFF5F5F5)
val TextGray = Color(0xFF757575)


private val LightColorScheme = lightColorScheme(
    primary = Orange,
    onPrimary = White,
    secondary = Color(0xFF616161),
    background = LightGray,
    surface = White,
    onSurface = Color(0xFF1A1A1A),
    onBackground = Color(0xFF1A1A1A),
    surfaceVariant = Color(0xFFE0E0E0),
    onSurfaceVariant = Color(0xFF424242)
)


private val DarkColorScheme = darkColorScheme(
    primary = Orange,
    onPrimary = White,
    secondary = Color(0xFF757575),
    background = DarkGray,
    surface = Color(0xFF2C2C2C),
    onSurface = White,
    onBackground = White,
    surfaceVariant = Color(0xFF404040),
    onSurfaceVariant = Color(0xFFBDBDBD)
)


@Composable
fun TrashDatingTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
