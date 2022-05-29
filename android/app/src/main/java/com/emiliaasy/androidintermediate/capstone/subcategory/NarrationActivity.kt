package com.emiliaasy.androidintermediate.capstone.subcategory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emiliaasy.androidintermediate.capstone.MainActivity
import com.emiliaasy.androidintermediate.capstone.databinding.ActivityNarrationBinding

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
        //
    }
}