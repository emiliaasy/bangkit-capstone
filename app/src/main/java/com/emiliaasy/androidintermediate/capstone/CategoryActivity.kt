package com.emiliaasy.androidintermediate.capstone

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import com.emiliaasy.androidintermediate.capstone.databinding.ActivityCategoryBinding
import com.emiliaasy.androidintermediate.capstone.databinding.ActivityMainBinding
import com.emiliaasy.androidintermediate.capstone.subcategory.AnimalsActivity
import com.emiliaasy.androidintermediate.capstone.subcategory.HouseActivity

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.houseButton.setOnClickListener {
            startActivity(Intent(this, HouseActivity::class.java))
        }

        binding.animalsButton.setOnClickListener {
            startActivity(Intent(this, AnimalsActivity::class.java))
        }

        setupView()
    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }
}