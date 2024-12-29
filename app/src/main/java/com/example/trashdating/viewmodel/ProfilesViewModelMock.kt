package com.example.trashdating.viewmodel

import com.example.trashdating.model.Profile
import com.example.trashdating.repository.impl.QuotesRepositoryMock
import com.example.trashdating.repository.impl.UsersRepositoryMock

val ProfilesViewModelMock = ProfilesViewModel(
    Profile(
        name = "Tim",
        email = "glhf@example.com",
        avatar = "http://images.com/0",
        hobby = "cooking",
        profileImage = "",
        matchPercent = 100
    ),
    UsersRepositoryMock(),
    QuotesRepositoryMock()
)