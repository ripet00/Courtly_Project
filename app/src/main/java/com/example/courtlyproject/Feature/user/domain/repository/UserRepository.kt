package com.example.courtlyproject.Feature.user.domain.repository

import com.example.courtlyproject.Feature.user.domain.model.User

interface UserRepository {
    suspend fun getUserById(userId: String): User?
}