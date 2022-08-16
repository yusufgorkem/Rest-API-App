package com.theappland.restapiapp.view.service

import com.theappland.restapiapp.view.model.PostModel
import io.reactivex.Single
import retrofit2.http.GET

interface PostAPI {
    //https://jsonplaceholder.typicode.com/posts
    //posts

    @GET("posts")
    fun getData() : Single<List<PostModel>>
}