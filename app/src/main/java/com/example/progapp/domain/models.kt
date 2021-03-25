package com.example.progapp.domain

import com.google.gson.annotations.SerializedName

data class User(
    val id: Int,
    val username: String,
    val email: String
)

data class Test(
    val id: Int,
    val title: String,
    val text: String,
    val date: String
)

data class TestsResponse(
    @SerializedName("status_code")
    var status: Int,

    @SerializedName("message")
    var message: String,

    @SerializedName("posts")
    var posts: List<Test>
)

data class RegisterBody(
    val username: String,
    val email: String,
    val password: String
)

data class SignInBody(val username: String, val password: String)