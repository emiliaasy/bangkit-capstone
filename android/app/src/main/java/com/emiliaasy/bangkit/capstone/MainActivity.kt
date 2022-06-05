package com.emiliaasy.bangkit.capstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emiliaasy.bangkit.capstone.databinding.ActivityMainBinding
import com.emiliaasy.bangkit.capstone.dialog.ExitDialogActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        setupActions()
    }

    private fun setupActions(){
        binding.menu.quit.setOnClickListener {
            startActivity(Intent(this, ExitDialogActivity::class.java))
        }

        binding.newButton.setOnClickListener {
            startActivity(Intent(this, CategoryActivity::class.java))
        }

        binding.continueButton.setOnClickListener {
            startActivity(Intent(this, StageActivity::class.java))
        }
    }
}