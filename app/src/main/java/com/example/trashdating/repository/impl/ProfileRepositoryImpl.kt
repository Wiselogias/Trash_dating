package com.example.trashdating.repository.impl

import com.example.trashdating.model.ProfileCard
import com.example.trashdating.model.Tags
import com.example.trashdating.repository.IProfileRepository

class ProfileRepositoryImpl : IProfileRepository {
    override fun getAuthorizedUserData(): ProfileCard =
        ProfileCard(
            name = "Alfredo Calzoni",
            city = "Hamburg, Germany",
            age = 20,
            distance = 2.5f,
            profileImage = "https://i.pinimg.com/736x/0d/21/a4/0d21a40b186a2d4aebf65cb48b7cbd2a.jpg",
            matchprocent = 80,
            tags = Tags(
                eats = listOf("Пицца", "Суши", "Бургеры", "Кофе"),
                socials = listOf(
                    "Кинотеатры",
                    "Концерты и шоу",
                    "Музеи и галлереи",
                    "Театры",
                    "Шоппинг"
                ),
                arts = listOf("Фотография", "Видеосъемка", "Дизайн", "Танцы"),
                life = listOf("Бег", "Фитнес", "Велосипед", "Лыжи", "Йога", "Сноуборд")
            )
        )


}