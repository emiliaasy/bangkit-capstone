package com.emiliaasy.bangkit.capstone.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emiliaasy.bangkit.capstone.databinding.ActivityCorrectResultBinding

class CorrectResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCorrectResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCorrectResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
    }
}