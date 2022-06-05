package com.emiliaasy.bangkit.capstone

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.emiliaasy.bangkit.capstone.databinding.ActivityCategoryBinding
import com.emiliaasy.bangkit.capstone.databinding.TemplateMenuBinding
import com.emiliaasy.bangkit.capstone.dialog.ExitDialogActivity
import com.emiliaasy.bangkit.capstone.subcategory.AnimalsActivity
import com.emiliaasy.bangkit.capstone.subcategory.HouseActivity


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

        binding.menu.quit.setOnClickListener {
            startActivity(Intent(this, ExitDialogActivity::class.java))
        }
    }
}