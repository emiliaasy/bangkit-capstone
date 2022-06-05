package com.emiliaasy.bangkit.capstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emiliaasy.bangkit.capstone.databinding.ActivityStageBinding
import com.emiliaasy.bangkit.capstone.dialog.ExitDialogActivity

class StageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        setupActions()
    }

    private fun setupActions() {
        binding.stage1.setOnClickListener {
            startActivity(Intent(this, NarrationActivity::class.java))
        }

        binding.stage2.setOnClickListener {
            startActivity(Intent(this, NarrationActivity::class.java))
        }

        binding.stage3.setOnClickListener {
            startActivity(Intent(this, NarrationActivity::class.java))
        }

        binding.menu.quit.setOnClickListener {
            startActivity(Intent(this, ExitDialogActivity::class.java))
        }

        binding.menu.quit.setOnClickListener {
            startActivity(Intent(this, ExitDialogActivity::class.java))
        }
    }
}