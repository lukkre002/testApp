package com.example.testapp.network

import com.example.testapp.Constants
import com.example.testapp.model.Comments
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CommentsRetriver {
    private val apiInterface : ApiInterface

    init {
        val retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        apiInterface = retrofit.create(ApiInterface::class.java)
    }

     suspend fun getComments() : List<Comments>{
        return apiInterface.getCommends()
    }
}