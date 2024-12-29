package com.example.trashdating.repository.impl

import com.example.trashdating.model.Hobby
import com.example.trashdating.model.Profile
import com.example.trashdating.repository.UsersRepository

class UsersRepositoryMock : UsersRepository {
    private var users = mutableMapOf(
        Pair(
            1,
            Profile(
                id = 1,
                name = "Anna",
                email = "anna@example.com",
                avatar = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRlwGc-VfxV9QMIkmFwxw7dD0rW74M9W7hHBw&s",
                hobby = Hobby.Travelling,
                profileImage = "https://img2.akspic.ru/previews/0/5/8/4/7/174850/174850-zakat_oblaka_estetika-oblako-zakat-estetika-atmosfera-500x.jpg",
                95
            )
        ),
        Pair(
            2,
            Profile(
                id = 2,
                name = "Mike",
                email = "mike@example.com",
                avatar = "https://sp-ao.shortpixel.ai/client/to_auto,q_glossy,ret_img,w_800,h_600/https://www.kirilltigai.com/wp-content/uploads/Muzhskaya-fotosessiya-v-studii-v-Kieve-fotograf-Kirill-Tigaj-_02-800x600.jpg",
                hobby = Hobby.Reading,
                profileImage = "https://i.pinimg.com/originals/57/03/ff/5703ff332958d819cd439928339549ee.jpg",
                90
            )
        ),
        Pair(
            3,
            Profile(
                id = 3,
                name = "Bob",
                email = "bob@example.com",
                avatar = "https://www.deafkontakt.ru/photos/3506663.jpg",
                hobby = Hobby.Cooking,
                profileImage = "https://i.pinimg.com/236x/1a/af/61/1aaf61b74ccc30ea596abf7a1db81639.jpg",
                100
            )
        ),
        Pair(
            4,
            Profile(
                id = 4,
                name = "Anna",
                email = "anna@example.com",
                avatar = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRlwGc-VfxV9QMIkmFwxw7dD0rW74M9W7hHBw&s",
                hobby = Hobby.Travelling,
                profileImage = "https://img2.akspic.ru/previews/0/5/8/4/7/174850/174850-zakat_oblaka_estetika-oblako-zakat-estetika-atmosfera-500x.jpg",
                95
            )
        ),
        Pair(
            5,
            Profile(
                id = 4,
                name = "Anna",
                email = "anna@example.com",
                avatar = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRlwGc-VfxV9QMIkmFwxw7dD0rW74M9W7hHBw&s",
                hobby = Hobby.Travelling,
                profileImage = "https://img2.akspic.ru/previews/0/5/8/4/7/174850/174850-zakat_oblaka_estetika-oblako-zakat-estetika-atmosfera-500x.jpg",
                95
            )
        ),
    )

    override fun getAllUsers() : List<Profile> {
        return users.values.toList()
    }

    override fun getFollowedUsers(user: Profile): List<Profile> {
        return users.values.toList()
    }

    override fun getMatches(user: Profile): List<Profile> {
        return users.values.toList()
    }

    override fun addUser(user: Profile) : List<Profile> {
        val id = users.size
        users[id] = user
        return getAllUsers()
    }
}