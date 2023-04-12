package com.example.fithoudemo.network.data

import com.google.gson.annotations.SerializedName

class LoginResponse {
    @SerializedName("name")
    val name: String? = null

    @SerializedName("token")
    var token: String? = null
}
