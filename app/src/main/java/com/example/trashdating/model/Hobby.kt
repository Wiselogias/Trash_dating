package com.example.trashdating.model

import com.example.trashdating.R

enum class Hobby(
    private val value: String,
    val sticker: Int
) {
    Travelling("travelling", R.drawable.palm_tree),
    Reading("reading", R.drawable.books),
    Cooking("cooking", R.drawable.cooking);

    companion object {
        fun fromValue(x: String): Hobby {
            for(hobby in entries) {
                if (x == hobby.value) {
                    return hobby
                }
            }
            throw IllegalArgumentException("No hobby with name $x")
        }
    }
}