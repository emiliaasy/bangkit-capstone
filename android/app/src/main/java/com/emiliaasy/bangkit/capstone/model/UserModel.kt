package com.emiliaasy.bangkit.capstone.model

data class UserModel(
    val name: String,
    val email: String,
    val password: String,
    val isLogin: Boolean
)