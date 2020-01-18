package com.example.kotlinserialization

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceHolderApi {

    @GET("todos/{id}")
    fun getTodo(
        @Path("id") id: Int
    ): Call<ToDo>

}