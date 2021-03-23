package com.example.progapp.ui.login

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.progapp.api.ApiInterface
import com.example.progapp.api.RetrofitInstance
import com.example.progapp.domain.SignInBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {
    // TODO: Implement the ViewModel
}

private fun singin(username: String, password: String, application: Application) {
    val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
    val signInInfo = SignInBody(username, password)
    retIn.signin(signInInfo).enqueue(object : Callback<ResponseBody> {
        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            Toast.makeText(
                application.applicationContext,
                t.message, Toast.LENGTH_SHORT
            ).show()
        }

        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
            if (response.code() == 200) {
                Toast.makeText(
                    application.applicationContext,
                    "Login success!!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    application.applicationContext,
                    "Login failed!", Toast.LENGTH_SHORT
                ).show()
            }
        }

    })
}