package com.emiliaasy.bangkit.capstone.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emiliaasy.bangkit.capstone.R
import com.emiliaasy.bangkit.capstone.databinding.ActivityLoginBinding
import com.emiliaasy.bangkit.capstone.dialog.ExitDialogActivity
import com.emiliaasy.bangkit.capstone.signup.RegisterActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        actionView()
    }

    private fun actionView() {
        //
    }
}