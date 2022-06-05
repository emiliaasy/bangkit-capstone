package com.emiliaasy.bangkit.capstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emiliaasy.bangkit.capstone.capture.CaptureActivity
import com.emiliaasy.bangkit.capstone.databinding.ActivityNarrationBinding
import com.emiliaasy.bangkit.capstone.dialog.ExitDialogActivity
import com.emiliaasy.bangkit.capstone.dialog.PauseDialogActivity

class NarrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNarrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNarrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        setupActions()
    }

    private fun setupActions() {
        binding.nextNavigation.setOnClickListener {
            startActivity(Intent(this, CaptureActivity::class.java))
        }

        binding.menu.pause.setOnClickListener {
            startActivity(Intent(this, PauseDialogActivity::class.java))
        }
    }
}