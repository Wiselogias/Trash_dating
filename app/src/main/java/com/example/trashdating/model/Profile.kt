package com.example.trashdating.model

import kotlin.random.Random

data class Profile(
    var id: Int,
    val name: String,
    val email: String,
    val avatar: String,
    val hobby: Hobby,
    val profileImage: String,
    val matchPercent: Int
) {
    constructor(
        name: String,
        email: String,
        avatar: String,
        hobby: String,
        profileImage: String,
        matchPercent: Int
    ) : this(
        id = Random.nextInt(),
        name = name,
        email = email,
        avatar = avatar,
        hobby = Hobby.fromValue(hobby),
        profileImage = profileImage,
        matchPercent = matchPercent
    )
}