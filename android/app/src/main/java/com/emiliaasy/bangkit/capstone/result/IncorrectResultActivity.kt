package com.emiliaasy.bangkit.capstone.result

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emiliaasy.bangkit.capstone.stage1.ExplanationActivity
import com.emiliaasy.bangkit.capstone.databinding.ActivityIncorrectResultBinding
import com.emiliaasy.bangkit.capstone.dialog.PauseDialogActivity

class IncorrectResultActivity  : AppCompatActivity() {
    private lateinit var binding: ActivityIncorrectResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIncorrectResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        actionView()
    }

    private fun actionView() {
        binding.nextNavigation.setOnClickListener {
            startActivity(Intent(this, ExplanationActivity::class.java))
        }

        binding.menu.pause.setOnClickListener {
            startActivity(Intent(this, PauseDialogActivity::class.java))
        }
    }

}