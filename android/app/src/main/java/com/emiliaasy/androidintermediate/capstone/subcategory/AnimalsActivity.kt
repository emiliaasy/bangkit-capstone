package com.emiliaasy.androidintermediate.capstone.subcategory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emiliaasy.androidintermediate.capstone.MainActivity
import com.emiliaasy.androidintermediate.capstone.StageActivity
import com.emiliaasy.androidintermediate.capstone.databinding.ActivityAnimalsBinding

class AnimalsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnimalsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        setupActions()
    }

    private fun setupActions() {
        binding.landAnimals.setOnClickListener {
            startActivity(Intent(this, StageActivity::class.java))
        }

        binding.underwaterAnimals.setOnClickListener {
            startActivity(Intent(this, StageActivity::class.java))
        }

        binding.insects.setOnClickListener {
            startActivity(Intent(this, StageActivity::class.java))
        }
    }
}