package com.example.kotlinserialization

import com.google.gson.Gson
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test

class KotlinSerializationUnitTest {

    private val jsonString = """
            {
                "name" : "Andi Wijaya",
                "email" : "andiwijayaid@gmail.com"
            }
        """.trimIndent()

    @Test
    fun gsonTest() {
        val user = Gson().fromJson(jsonString, User::class.java)

        assertEquals("Andi Wijaya", user.name)
        assertEquals(0, user.age)
        println("Gson -> ${user.name}, ${user.email}, ${user.age}, ${user.placeOfBirth}")
        assertEquals(null, user.placeOfBirth)
//      User(name=Andi Wijaya, email=andiwijayaid@gmail.com, age=0, placeOfBirth=null)
    }

    @Test
    fun jsonTest() {
        val user = Json.parse(User.serializer(), jsonString)

        assertEquals("Andi Wijaya", user.name)
        assertEquals(13, user.age)
        println("Json -> ${user.name}, ${user.email}, ${user.age}, ${user.placeOfBirth}")
        assertEquals("Makassar", user.placeOfBirth)
//      User(name=Andi Wijaya, email=andiwijayaid@gmail.com, age=13, placeOfBirth=Makassar)
    }
}