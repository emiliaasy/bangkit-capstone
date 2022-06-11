package com.emiliaasy.bangkit.capstone

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.emiliaasy.bangkit.capstone.databinding.ActivityStageBinding
import com.emiliaasy.bangkit.capstone.dialog.ExitDialogActivity
import com.emiliaasy.bangkit.capstone.model.UserPreference
import com.emiliaasy.bangkit.capstone.model.UserViewModel
import com.emiliaasy.bangkit.capstone.model.ViewModelFactory

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user")

class StageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStageBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStageBinding.inflate(layoutInflater)
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
        binding.stage1.setOnClickListener {
            startActivity(Intent(this, NarrationActivity::class.java))
        }

        binding.stage2.setOnClickListener {
            startActivity(Intent(this, NarrationActivity::class.java))
        }

        binding.stage3.setOnClickListener {
            startActivity(Intent(this, NarrationActivity::class.java))
        }

        binding.menu.quit!!.setOnClickListener {
            startActivity(Intent(this, ExitDialogActivity::class.java))
        }

    }
}