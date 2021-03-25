package com.example.progapp.ui.login

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.progapp.api.ApiInterface
import com.example.progapp.api.RetrofitInstance
import com.example.progapp.domain.SignInBody
import okhttp3.Credentials
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {
    private val _eventButtonClicked = MutableLiveData<Boolean>()
    val eventButtonClicked: LiveData<Boolean>
        get() = _eventButtonClicked

    fun onButtonClicked() {
        _eventButtonClicked.value = true
    }


    fun signin(username: String, password: String, context: Context) {
        _eventButtonClicked.value = false
        val retIn = RetrofitInstance.getRetrofitInstance(context).create(ApiInterface::class.java)
        val signInInfo = SignInBody(username, password)
        var basic = Credentials.basic("b", "b")
        retIn.signin(basic).enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d("error", "" + t)
                Log.d("error", "" + call)

            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.code() == 200) {
                    Log.d("error", "" + call)

                } else {

                }
                Log.d("error", "" + call)
            }

        })
    }
}


