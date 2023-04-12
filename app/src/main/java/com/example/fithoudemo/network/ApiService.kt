package com.example.fithoudemo.network

import com.example.fithoudemo.network.data.LoginRequest
import com.example.fithoudemo.network.data.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("v1/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>
}
