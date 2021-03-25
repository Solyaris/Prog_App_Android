package com.example.progapp.api

import android.content.Context
import com.example.progapp.domain.RegisterBody
import com.example.progapp.domain.SignInBody
import com.example.progapp.domain.TestsResponse
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiInterface {

    @Headers("Content-Type:application/json")
    @POST("tokens")
    fun signin(@Header("Authorization") h1:String): retrofit2.Call<ResponseBody>

    @Headers("Content-Type:application/json")
    @POST("users")
    fun registerUser(@Body info: RegisterBody): retrofit2.Call<ResponseBody>

    @GET("users/")
    fun fetchTests(@Header("Authorization") token: String): retrofit2.Call<TestsResponse>

}

class RetrofitInstance {
    companion object {
        val BASE_URL: String = "http://10.0.2.2:5000/api/"
        val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        val client: OkHttpClient = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
        }.build()

        fun getRetrofitInstance(context: Context): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okhttpClient(context))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        private fun okhttpClient(context: Context): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(AuthInterceptor(context))
                .build()
        }
    }
}