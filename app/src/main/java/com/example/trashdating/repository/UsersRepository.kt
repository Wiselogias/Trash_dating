package com.example.trashdating.repository

import com.example.trashdating.model.Profile

interface UsersRepository {
    fun getAllUsers(): List<Profile>
    fun addUser(user: Profile): List<Profile>
    fun getFollowedUsers(user: Profile): List<Profile>
    fun getMatches(user: Profile): List<Profile>
}
