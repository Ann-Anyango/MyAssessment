package com.example.myassessment.Repository

import android.telecom.Call
import com.example.myassessment.Model.Post
import com.example.myassessment.api.apiServices
import javax.security.auth.callback.Callback

class PostRepository (private val apiService: apiServices) {

    fun getPosts(callback: (List<Post>?) -> Unit) {
        apiService.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    val posts = response.body()
                    callback(posts)
                } else {
                    callback(null)
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                callback(null)
            }
        })
    }
}
