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
import com.emiliaasy.bangkit.capstone.data.UserPreference
import com.emiliaasy.bangkit.capstone.databinding.ActivityMainBinding
import com.emiliaasy.bangkit.capstone.dialog.ExitDialogActivity

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user")

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        mainViewModel = ViewModelProvider(
            this,
            ViewModelFactory(UserPreference.getInstance(dataStore))
        )[MainViewModel::class.java]

        mainViewModel.getUser().observe(this) { user ->
            if (user.isLogin) {
                binding.menu.user!!.text = getString(R.string.greeting, user.name)
            } else {
                startActivity(Intent(this, WelcomeActivity::class.java))
                finish()
            }
        }

        setupActions()
    }

    private fun setupActions(){
        binding.menu.quit!!.setOnClickListener {
            startActivity(Intent(this, ExitDialogActivity::class.java))
        }

        binding.newButton.setOnClickListener {
            startActivity(Intent(this, CategoryActivity::class.java))
        }

        binding.continueButton.setOnClickListener {
            startActivity(Intent(this, StageActivity::class.java))
        }

        binding.menu.logout.setOnClickListener {
            mainViewModel.logout()
        }
    }
}