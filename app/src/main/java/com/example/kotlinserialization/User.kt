package com.example.kotlinserialization

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name: String,
    val email: String,
    val age: Int = 13,
    val placeOfBirth: String? = "Makassar"
)