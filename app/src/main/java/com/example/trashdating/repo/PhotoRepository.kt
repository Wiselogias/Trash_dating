package com.example.trashdating.repo

import androidx.compose.runtime.Composable
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter

class PhotoRepository {
    @Composable
    fun getPhoto(url: String): AsyncImagePainter {
        return rememberAsyncImagePainter(model = url)
    }
}