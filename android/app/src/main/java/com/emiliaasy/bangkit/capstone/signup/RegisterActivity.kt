package com.emiliaasy.bangkit.capstone.signup

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
import com.emiliaasy.bangkit.capstone.model.ViewModelFactory
import com.emiliaasy.bangkit.capstone.model.UserModel
import com.emiliaasy.bangkit.capstone.model.UserPreference
import com.emiliaasy.bangkit.capstone.databinding.ActivityRegisterBinding
import com.emiliaasy.bangkit.capstone.dialog.ExitDialogActivity
import com.emiliaasy.bangkit.capstone.dialog.RegisterDialogActivity

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user")

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var signupViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        signupViewModel = ViewModelProvider(
            this,
            ViewModelFactory(UserPreference.getInstance(dataStore))
        )[RegisterViewModel::class.java]

        actionView()
        animationView()
    }

    private fun actionView() {
        binding.signupButton.setOnClickListener {
            signup()
        }

        binding.quit.setOnClickListener {
            startActivity(Intent(this, ExitDialogActivity::class.java))
        }
    }

    private fun signup() {
        val name = binding.nameEditText.text.toString()
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        when {
            name.isEmpty() -> {
                binding.nameEditTextLayout.error = "Masukkan email"
            }
            email.isEmpty() -> {
                binding.emailEditTextLayout.error = "Masukkan email"
            }
            !isValidEmail(email) -> {
                binding.emailEditTextLayout.error = "Email tidak valid"
            }
            password.isEmpty() -> {
                binding.passwordEditTextLayout.error = "Masukkan password"
            }
            password.length < 6 -> {
                binding.passwordEditTextLayout.error = "Password minimal 6 karakter"
            }
            else -> {
                signupViewModel.saveUser(UserModel(name, email, password, false))
                startActivity(Intent(this, RegisterDialogActivity::class.java))
            }
        }
    }

    private fun isValidEmail(email: CharSequence): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun animationView() {
        ObjectAnimator.ofFloat(binding.imageView, View.ROTATION, -1f, 1f).apply {
            duration = 600
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()
    }
}