package com.example.trashdating.viewmodel

import androidx.lifecycle.ViewModel
import com.example.trashdating.model.Profile
import com.example.trashdating.repository.QuotesRepository
import com.example.trashdating.repository.UsersRepository

class ProfilesViewModel(
    me: Profile,
    private val usersRepository: UsersRepository,
    quotesRepository: QuotesRepository
): ViewModel() {
    private var _followed: List<Profile> = usersRepository.getFollowedUsers(me)
    private var _profiles: List<Profile>
    private var _quotes: List<String>
    private var _matches: List<Profile>

    init {
        _profiles = usersRepository.getAllUsers()
        _quotes = _profiles.map { p -> quotesRepository.getQuote(p.id) }
        _matches = usersRepository.getMatches(me)
    }

    val followed: List<Profile>
        get() =  _followed

    val profiles: List<Profile>
        get() =  _profiles

    val matches: List<Profile>
        get() = _matches

    val likes: Int = 15
    val messages: Int = 34

    fun addUser(user: Profile) {
        _profiles = usersRepository.addUser(user)
    }

    fun getQuote(id: Int) : String {
        return _quotes[id - 1]
    }
}