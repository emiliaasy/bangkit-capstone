package com.emiliaasy.androidintermediate.capstone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emiliaasy.androidintermediate.capstone.databinding.ActivityStageBinding

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
        //
    }
}