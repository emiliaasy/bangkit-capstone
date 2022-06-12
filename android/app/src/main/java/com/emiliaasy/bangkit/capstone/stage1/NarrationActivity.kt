package com.emiliaasy.bangkit.capstone.stage1

import android.content.Context
import android.content.Intent
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.emiliaasy.bangkit.capstone.R
import com.emiliaasy.bangkit.capstone.capture.CaptureActivity
import com.emiliaasy.bangkit.capstone.databinding.ActivityNarrationBinding
import com.emiliaasy.bangkit.capstone.dialog.PauseDialogActivity
import com.emiliaasy.bangkit.capstone.model.UserPreference
import com.emiliaasy.bangkit.capstone.model.UserViewModel
import com.emiliaasy.bangkit.capstone.model.ViewModelFactory

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user")

class NarrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNarrationBinding
    private lateinit var userViewModel: UserViewModel
    private lateinit var sp: SoundPool
    private var soundId: Int = 0
    private var spLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNarrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        sp = SoundPool.Builder()
            .setMaxStreams(10)
            .build()
        sp.setOnLoadCompleteListener { _, _, status ->
            if (status == 0) {
                spLoaded = true
            } else {
                Toast.makeText(this, "Gagal load", Toast.LENGTH_SHORT).show()
            }
        }

        soundId = sp.load(this, R.raw.audio1, 1)

        userViewModel = ViewModelProvider(
            this,
            ViewModelFactory(UserPreference.getInstance(dataStore))
        )[UserViewModel::class.java]

        userViewModel.getUser().observe(this) { user ->
            binding.textNarration!!.text = getString(R.string.narasi1, user.name)
        }
        setupActions()
    }

    private fun setupActions() {
        binding.nextNavigation.setOnClickListener {
            startActivity(Intent(this, CaptureActivity::class.java))
        }

        binding.menu.pause.setOnClickListener {
            startActivity(Intent(this, PauseDialogActivity::class.java))
        }

        binding.audio.setOnClickListener {
            if (spLoaded) {
                sp.play(soundId, 1f, 1f, 0, 0, 1f)
            }

        }
    }
}