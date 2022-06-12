package com.emiliaasy.bangkit.capstone.result

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emiliaasy.bangkit.capstone.stage1.ExplanationActivity
import com.emiliaasy.bangkit.capstone.databinding.ActivityCorrectResultBinding
import com.emiliaasy.bangkit.capstone.dialog.PauseDialogActivity

class CorrectResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCorrectResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCorrectResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        actionView()
    }

    private fun actionView() {
        binding.nextNavigation.setOnClickListener {
            startActivity(Intent(this, IncorrectResultActivity::class.java))
        }

        binding.menu.pause.setOnClickListener {
            startActivity(Intent(this, PauseDialogActivity::class.java))
        }
    }

}