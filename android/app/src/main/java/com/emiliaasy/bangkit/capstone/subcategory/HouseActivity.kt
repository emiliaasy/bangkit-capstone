package com.emiliaasy.bangkit.capstone.subcategory

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.emiliaasy.bangkit.capstone.R
import com.emiliaasy.bangkit.capstone.StageActivity
import com.emiliaasy.bangkit.capstone.WelcomeActivity
import com.emiliaasy.bangkit.capstone.databinding.ActivityHouseBinding
import com.emiliaasy.bangkit.capstone.dialog.ExitDialogActivity
import com.emiliaasy.bangkit.capstone.model.UserPreference
import com.emiliaasy.bangkit.capstone.model.UserViewModel
import com.emiliaasy.bangkit.capstone.model.ViewModelFactory

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user")

class HouseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHouseBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHouseBinding.inflate(layoutInflater)
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

        setupActions()
    }

    private fun setupActions() {
        binding.livingRoom.setOnClickListener {
            startActivity(Intent(this, StageActivity::class.java))
        }

        binding.menu.quit!!.setOnClickListener {
            startActivity(Intent(this, ExitDialogActivity::class.java))
        }
    }
}