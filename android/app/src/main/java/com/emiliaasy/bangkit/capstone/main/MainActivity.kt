package com.emiliaasy.bangkit.capstone.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.emiliaasy.bangkit.capstone.*
import com.emiliaasy.bangkit.capstone.category.CategoryActivity
import com.emiliaasy.bangkit.capstone.model.UserPreference
import com.emiliaasy.bangkit.capstone.databinding.ActivityMainBinding
import com.emiliaasy.bangkit.capstone.dialog.ExitDialogActivity
import com.emiliaasy.bangkit.capstone.dialog.LoginDialogActivity
import com.emiliaasy.bangkit.capstone.dialog.LogoutDialogActivity
import com.emiliaasy.bangkit.capstone.model.UserViewModel
import com.emiliaasy.bangkit.capstone.model.ViewModelFactory

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user")

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        userViewModel = ViewModelProvider(
            this,
            ViewModelFactory(UserPreference.getInstance(dataStore))
        )[UserViewModel::class.java]

        userViewModel.getUser().observe(this) { user ->
            if (user.isLogin) {
                binding.user.text = getString(R.string.greeting, user.name)
            } else {
                startActivity(Intent(this, WelcomeActivity::class.java))
                finish()
            }
        }

        setupActions()
    }

    private fun setupActions(){
        binding.quit.setOnClickListener {
            startActivity(Intent(this, ExitDialogActivity::class.java))
        }

        binding.newButton.setOnClickListener {
            startActivity(Intent(this, CategoryActivity::class.java))
        }

        binding.continueButton.setOnClickListener {
            startActivity(Intent(this, StageActivity::class.java))
        }

        binding.logout.setOnClickListener {
            startActivity(Intent(this, LogoutDialogActivity::class.java))
        }
    }
}