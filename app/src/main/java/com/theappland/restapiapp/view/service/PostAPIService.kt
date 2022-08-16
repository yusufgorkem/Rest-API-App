package com.theappland.restapiapp.view.service

import com.theappland.restapiapp.view.model.PostModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PostAPIService {
    //https://jsonplaceholder.typicode.com/posts
    //https://jsonplaceholder.typicode.com/
    private val baseUrl = "https://jsonplaceholder.typicode.com/"
    private val api = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(PostAPI::class.java)

    fun getData() : Single<List<PostModel>> {
        return api.getData()
    }
}