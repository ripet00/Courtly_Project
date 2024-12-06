package com.example.courtlyproject.Feature.auth.domain.repository

import com.example.courtlyproject.Feature.auth.domain.model.User
import com.example.courtlyproject.util.AppResult

interface AuthRepository {
    suspend fun signupUser(user: User): AppResult<Boolean>
    suspend fun loginWithEmail(email: String, password: String): AppResult<Boolean>
    suspend fun loginWithGoogle(idToken: String): AppResult<Boolean>
}