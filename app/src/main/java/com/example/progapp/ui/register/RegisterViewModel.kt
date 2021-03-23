package com.example.progapp.ui.register

import android.app.Application
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.*
import com.example.progapp.api.ApiInterface
import com.example.progapp.api.RetrofitInstance
import com.example.progapp.domain.RegisterBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterViewModel : ViewModel(){
    private val _eventButtonClicked = MutableLiveData<Boolean>()
    val eventButtonClicked: LiveData<Boolean>
        get() = _eventButtonClicked


    fun onButtonClicked() {
        _eventButtonClicked.value = true
    }
    fun onRegisterPassed(){
        _eventButtonClicked.value = false
    }

    fun signup(
        username: String,
        email: String,
        password: String,
        context: Context?
    ) {
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
//        val registerInfo = RegisterBody(username, email, password)
        val registerInfo = RegisterBody("b", "b@example.com", "b")

        retIn.registerUser(registerInfo).enqueue(object :
            Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d("error", ""+t)
                Toast.makeText(
                    context,
                    call.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Toast.makeText(
                    context,
                    call.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }

        })

    }
}
