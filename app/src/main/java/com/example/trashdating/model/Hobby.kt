package com.example.trashdating.model

enum class Hobby(private val value: String) {
    Travelling("travelling"),
    Reading("reading"),
    Cooking("cooking");

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