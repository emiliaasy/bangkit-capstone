package com.emiliaasy.bangkit.capstone.dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emiliaasy.bangkit.capstone.databinding.ActivityExitDialogBinding
import kotlin.system.exitProcess

class ExitDialogActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExitDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExitDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.setFinishOnTouchOutside(false);

        supportActionBar?.hide()

        setupActions()
    }

    private fun setupActions() {
        binding.cancelButton.setOnClickListener {
            onBackPressed()
        }

        binding.exitButton.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
    }
}