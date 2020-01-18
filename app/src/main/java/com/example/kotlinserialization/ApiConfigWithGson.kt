package com.example.kotlinserialization

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfigWithGson {

    private fun doRequestWithGson(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun instance(): JsonPlaceHolderApi {
        return doRequestWithGson().create(JsonPlaceHolderApi::class.java)
    }

}