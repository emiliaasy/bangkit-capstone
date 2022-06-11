package com.emiliaasy.bangkit.capstone.dialog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emiliaasy.bangkit.capstone.main.MainActivity
import com.emiliaasy.bangkit.capstone.databinding.ActivityPauseDialogBinding

class PauseDialogActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPauseDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPauseDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.setFinishOnTouchOutside(false);

        supportActionBar?.hide()

        setupActions()
    }

    private fun setupActions() {
        binding.mainMenuButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.resumeButton.setOnClickListener {
            onBackPressed()
        }
    }
}