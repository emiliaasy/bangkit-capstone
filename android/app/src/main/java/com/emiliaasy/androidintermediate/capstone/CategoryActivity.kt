package com.emiliaasy.androidintermediate.capstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emiliaasy.androidintermediate.capstone.databinding.ActivityCategoryBinding
import com.emiliaasy.androidintermediate.capstone.subcategory.AnimalsActivity
import com.emiliaasy.androidintermediate.capstone.subcategory.HouseActivity

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        actionView()
    }

    private fun actionView() {
        binding.houseButton.setOnClickListener {
            startActivity(Intent(this, HouseActivity::class.java))
        }

        binding.animalsButton.setOnClickListener {
            startActivity(Intent(this, AnimalsActivity::class.java))
        }
    }
}