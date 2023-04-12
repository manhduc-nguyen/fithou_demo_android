package com.example.fithoudemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.fithoudemo.databinding.ActivityMainBinding
import com.example.fithoudemo.presentation.LoginViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val loginViewModel = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()

        observeLiveData()
    }

    private fun initView() {
        binding.btnLogin.setOnClickListener {
            loginViewModel.login(
                binding.txtEmail.text.toString(),
                binding.txtPassword.text.toString()
            )
        }
    }

    private fun observeLiveData() {
        loginViewModel.isLoading.observe(this, Observer {
            it?.let {
                if (it) {
                    binding.btnLogin.visibility = View.GONE
                    binding.progressBar.visibility = View.VISIBLE

                } else {
                    binding.btnLogin.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                }
            }

        })
    }
}
