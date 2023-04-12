package com.example.fithoudemo.presentation

import androidx.lifecycle.MutableLiveData
import com.example.fithoudemo.repositories.AccountRepository
import com.example.fithoudemo.repositories.OnLoginListener

class LoginViewModel {
    private val accountRepository = AccountRepository()

    val isLoading = MutableLiveData<Boolean>(false)

    fun login(userName: String, password: String) {
        if (!isLoginDataValid(userName, password)) return
        isLoading.value = true
        accountRepository.login(userName, password, object : OnLoginListener {
            override fun onLoginResult(result: Boolean) {
                isLoading.value = false
            }
        })
    }

    private fun isLoginDataValid(userName: String, password: String): Boolean {
        return !(userName.isEmpty() || password.isEmpty())
    }
}
