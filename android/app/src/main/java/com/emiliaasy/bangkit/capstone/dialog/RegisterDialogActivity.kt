package com.emiliaasy.bangkit.capstone.dialog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emiliaasy.bangkit.capstone.databinding.ActivityRegisterDialogBinding
import com.emiliaasy.bangkit.capstone.login.LoginActivity

class RegisterDialogActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.setFinishOnTouchOutside(false);

        supportActionBar?.hide()

        setupActions()
    }

    private fun setupActions() {
        binding.okButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}