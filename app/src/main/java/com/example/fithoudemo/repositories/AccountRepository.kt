package com.example.fithoudemo.repositories

import com.example.fithoudemo.network.ApiService
import com.example.fithoudemo.network.data.LoginRequest
import com.example.fithoudemo.network.data.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AccountRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://6435172a83a30bc9ad57ad7a.mockapi.io/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun login(userName: String, password: String, onLoginListener: OnLoginListener) {
        val service = retrofit.create(ApiService::class.java)
        val call = service.login(LoginRequest(userName, password))

        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    onLoginListener.onLoginResult(response.body().token?.isNotEmpty() ?: false)
                } else {
                    onLoginListener.onLoginResult(false)
                }
            }

            override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {
                onLoginListener.onLoginResult(false)
            }
        })
    }
}

interface OnLoginListener {
    fun onLoginResult(result: Boolean)
}
