package com.theappland.restapiapp.view.model

import com.google.gson.annotations.SerializedName

data class PostModel(
    val userId : Int,
    @SerializedName("title")
    val postTitle : String,
)