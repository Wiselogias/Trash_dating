package com.example.trashdating.viewmodel

import androidx.lifecycle.ViewModel
import com.example.trashdating.model.ProfileCard
import com.example.trashdating.repository.IProfileRepository

class ProfileCardViewModel(
    profileRepository: IProfileRepository
) : ViewModel() {
    private var _autorizedUserProfileData: ProfileCard = profileRepository.getAuthorizedUserData()


    val authorizedUserData: ProfileCard
        get() = _autorizedUserProfileData

}