package com.example.trashdating.repository

import com.example.trashdating.model.ProfileCard

interface IProfileRepository {
    fun getAuthorizedUserData(): ProfileCard
}