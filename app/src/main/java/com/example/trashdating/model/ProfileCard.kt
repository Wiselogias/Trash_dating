package com.example.trashdating.model



data class ProfileCard(
    val name: String,
    val city: String,
    val age: Int,
    val distance: Float,
    val profileImage: String,
    val matchprocent: Int,
    val tags: Tags
) {

}