package com.emiliaasy.bangkit.capstone.subcategory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emiliaasy.bangkit.capstone.StageActivity
import com.emiliaasy.bangkit.capstone.databinding.ActivityHouseBinding
import com.emiliaasy.bangkit.capstone.dialog.ExitDialogActivity

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

        binding.menu.quit.setOnClickListener {
            startActivity(Intent(this, ExitDialogActivity::class.java))
        }
    }
}