package com.example.progapp.domain

data class User(
    val id: Int,
    val username: String,
    val email: String
)

data class RegisterBody(
    val username: String,
    val email: String,
    val password: String
)

data class SignInBody(val username: String, val password: String)