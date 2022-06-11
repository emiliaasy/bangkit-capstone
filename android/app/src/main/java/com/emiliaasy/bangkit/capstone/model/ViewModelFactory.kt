package com.emiliaasy.bangkit.capstone.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emiliaasy.bangkit.capstone.login.LoginViewModel
import com.emiliaasy.bangkit.capstone.main.MainViewModel
import com.emiliaasy.bangkit.capstone.signup.RegisterViewModel

class ViewModelFactory(private val pref: UserPreference) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(UserViewModel::class.java) -> {
                UserViewModel(pref) as T
            }
            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> {
                RegisterViewModel(pref) as T
            }
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(pref) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}