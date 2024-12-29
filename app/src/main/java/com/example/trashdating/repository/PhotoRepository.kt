package com.example.trashdating.repository

import androidx.compose.runtime.Composable
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter

class PhotoRepository {
    @Composable
    fun getPhoto(url: String): AsyncImagePainter {
        return rememberAsyncImagePainter(model = url)
    }
}