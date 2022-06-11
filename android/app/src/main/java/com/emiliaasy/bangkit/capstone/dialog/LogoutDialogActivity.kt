package com.emiliaasy.bangkit.capstone.dialog

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.emiliaasy.bangkit.capstone.databinding.ActivityLogoutDialogBinding
import com.emiliaasy.bangkit.capstone.model.UserPreference
import com.emiliaasy.bangkit.capstone.model.UserViewModel
import com.emiliaasy.bangkit.capstone.model.ViewModelFactory

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user")

class LogoutDialogActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogoutDialogBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogoutDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.setFinishOnTouchOutside(false);

        supportActionBar?.hide()

        userViewModel = ViewModelProvider(
            this,
            ViewModelFactory(UserPreference.getInstance(dataStore))
        )[UserViewModel::class.java]

        setupActions()
    }

    private fun setupActions() {
        binding.cancelButton.setOnClickListener {
            onBackPressed()
        }

        binding.okButton.setOnClickListener {
            userViewModel.logout()
        }
    }
}