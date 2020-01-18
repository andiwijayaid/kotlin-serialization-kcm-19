package com.example.kotlinserialization


import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class ToDo(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int,
    val numberOfClick: Int? = 10,
    @Transient
    val place: String = "Makassar"
)