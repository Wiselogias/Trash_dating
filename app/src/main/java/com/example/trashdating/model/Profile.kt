package com.example.trashdating.model



data class Profile(
    val name: String,
    val city: String,
    val age: Int,
    val distance: Int,
    val profileImage: String,
    val matchprocent: Int,
    val tags: Tags
) {

}