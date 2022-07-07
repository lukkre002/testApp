package com.example.testapp.network

import com.example.testapp.model.Comments
import retrofit2.http.GET

interface ApiInterface {
    @GET("/comments")
    suspend fun getCommends(): List<Comments>
}