package com.emiliaasy.bangkit.capstone

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.emiliaasy.bangkit.capstone.databinding.ActivityWelcomeBinding
import com.emiliaasy.bangkit.capstone.dialog.ExitDialogActivity
import com.emiliaasy.bangkit.capstone.login.LoginActivity
import com.emiliaasy.bangkit.capstone.signup.RegisterActivity

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        actionView()
        animationView()
    }

    private fun actionView() {
        binding.loginButton.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.registButton.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.quit.setOnClickListener {
            startActivity(Intent(this, ExitDialogActivity::class.java))
        }
    }

    private fun animationView() {
        ObjectAnimator.ofFloat(binding.image, View.TRANSLATION_X, -10f, 10f).apply {
            duration = 600
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

        val login = ObjectAnimator.ofFloat(binding.loginButton, View.ALPHA, 1f).setDuration(500)
        val signup = ObjectAnimator.ofFloat(binding.registButton, View.ALPHA, 1f).setDuration(500)
        val title = ObjectAnimator.ofFloat(binding.textView, View.ALPHA, 1f).setDuration(500)
        val desc = ObjectAnimator.ofFloat(binding.textView1, View.ALPHA, 1f).setDuration(500)

        val together = AnimatorSet().apply {
            playTogether(login, signup)
        }

        AnimatorSet().apply {
            playSequentially(title, desc, together)
            start()
        }
    }
}