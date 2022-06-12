package com.emiliaasy.bangkit.capstone.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.emiliaasy.bangkit.capstone.main.MainActivity
import com.emiliaasy.bangkit.capstone.model.ViewModelFactory
import com.emiliaasy.bangkit.capstone.model.UserModel
import com.emiliaasy.bangkit.capstone.model.UserPreference
import com.emiliaasy.bangkit.capstone.databinding.ActivityLoginBinding
import com.emiliaasy.bangkit.capstone.dialog.ExitDialogActivity
import com.emiliaasy.bangkit.capstone.dialog.LoginDialogActivity
import com.emiliaasy.bangkit.capstone.dialog.RegisterDialogActivity

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user")

class LoginActivity : AppCompatActivity() {
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding
    private lateinit var user: UserModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        loginViewModel = ViewModelProvider(
            this,
            ViewModelFactory(UserPreference.getInstance(dataStore))
        )[LoginViewModel::class.java]

        loginViewModel.getUser().observe(this) { user ->
            this.user = user
        }

        actionView()
        animationView()
    }

    private fun actionView() {
        binding.loginButton.setOnClickListener {
            login()
        }

        binding.quit.setOnClickListener {
            startActivity(Intent(this, ExitDialogActivity::class.java))
        }
    }

    private fun login() {
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        when {
            email.isEmpty() -> {
                binding.emailEditTextLayout.error = "Masukkan email"
            }
            password.isEmpty() -> {
                binding.passwordEditTextLayout.error = "Masukkan password"
            }
            email != user.email -> {
                binding.emailEditTextLayout.error = "Email tidak sesuai"
            }
            password != user.password -> {
                binding.passwordEditTextLayout.error = "Password tidak sesuai"
            }
            else -> {
                loginViewModel.login()
                startActivity(Intent(this, LoginDialogActivity::class.java))
            }
        }
    }

    private fun animationView() {
        ObjectAnimator.ofFloat(binding.imageView, View.ROTATION, -1f, 1f).apply {
            duration = 600
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()
    }
}