package com.emiliaasy.androidintermediate.capstone.subcategory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emiliaasy.androidintermediate.capstone.MainActivity
import com.emiliaasy.androidintermediate.capstone.StageActivity
import com.emiliaasy.androidintermediate.capstone.databinding.ActivityHouseBinding

class HouseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHouseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHouseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        setupActions()
    }

    private fun setupActions() {
        binding.livingRoom.setOnClickListener {
            startActivity(Intent(this, StageActivity::class.java))
        }

        binding.bedRoom.setOnClickListener {
            startActivity(Intent(this, StageActivity::class.java))
        }
    }
}