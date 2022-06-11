package com.emiliaasy.bangkit.capstone.category

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.emiliaasy.bangkit.capstone.R
import com.emiliaasy.bangkit.capstone.model.ViewModelFactory
import com.emiliaasy.bangkit.capstone.WelcomeActivity
import com.emiliaasy.bangkit.capstone.model.UserPreference
import com.emiliaasy.bangkit.capstone.databinding.ActivityCategoryBinding
import com.emiliaasy.bangkit.capstone.dialog.ExitDialogActivity
import com.emiliaasy.bangkit.capstone.model.UserViewModel
import com.emiliaasy.bangkit.capstone.subcategory.AnimalsActivity
import com.emiliaasy.bangkit.capstone.subcategory.HouseActivity

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user")

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        userViewModel = ViewModelProvider(
            this,
            ViewModelFactory(UserPreference.getInstance(dataStore))
        )[UserViewModel::class.java]

        userViewModel.getUser().observe(this) { user ->
            if (user.isLogin) {
                binding.menu.user.text = getString(R.string.greeting, user.name)
            } else {
                startActivity(Intent(this, WelcomeActivity::class.java))
                finish()
            }
        }

        actionView()
    }

    private fun actionView() {
        binding.houseButton.setOnClickListener {
            startActivity(Intent(this, HouseActivity::class.java))
        }

        binding.animalsButton.setOnClickListener {
            startActivity(Intent(this, AnimalsActivity::class.java))
        }

        binding.menu.quit!!.setOnClickListener {
            startActivity(Intent(this, ExitDialogActivity::class.java))
        }
    }
}