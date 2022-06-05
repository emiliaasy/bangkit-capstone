package com.emiliaasy.bangkit.capstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emiliaasy.bangkit.capstone.databinding.ActivityExplanationBinding
import com.emiliaasy.bangkit.capstone.dialog.PauseDialogActivity

class ExplanationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExplanationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExplanationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        setupActions()
    }

    private fun setupActions() {
        binding.nextNavigation.setOnClickListener {
            startActivity(Intent(this, StageActivity::class.java))
        }

        binding.menu.pause.setOnClickListener {
            startActivity(Intent(this, PauseDialogActivity::class.java))
        }
    }
}