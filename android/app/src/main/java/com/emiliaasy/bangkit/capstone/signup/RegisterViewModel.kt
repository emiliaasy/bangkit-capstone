package com.emiliaasy.bangkit.capstone.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emiliaasy.bangkit.capstone.data.UserModel
import com.emiliaasy.bangkit.capstone.data.UserPreference
import kotlinx.coroutines.launch

class RegisterViewModel(private val pref: UserPreference) : ViewModel()  {
    fun saveUser(user: UserModel) {
        viewModelScope.launch {
            pref.saveUser(user)
        }
    }
}