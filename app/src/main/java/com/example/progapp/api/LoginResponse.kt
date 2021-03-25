package com.example.progapp.api

import com.example.progapp.domain.User
import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("status_code")
    var statusCoded: Int,

    @SerializedName("auth_token")
    var authToken: String,

    @SerializedName("user")
    var user: User


)