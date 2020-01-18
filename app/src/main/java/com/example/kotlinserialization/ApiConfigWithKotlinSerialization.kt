package com.example.kotlinserialization

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

class ApiConfigWithKotlinSerialization {


    private fun doRequestWithKotlinSerialization(): Retrofit {
        val contentType = MediaType.get("application/json")
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }

    fun instance(): JsonPlaceHolderApi {
        return doRequestWithKotlinSerialization().create(JsonPlaceHolderApi::class.java)
    }

}