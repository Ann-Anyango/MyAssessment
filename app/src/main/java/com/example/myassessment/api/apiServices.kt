package com.example.myassessment.api

import android.telecom.Call
import com.example.myassessment.Model.Post
import retrofit2.http.GET

interface apiServices {
    @GET("https://jsonplaceholder.typicode.com/posts")
    fun getPosts(): Call<List<Post>>
}