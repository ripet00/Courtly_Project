package com.example.courtlyproject.Feature.user.domain.usecase

import android.util.Log
import com.example.courtlyproject.Feature.user.domain.model.User
import com.example.courtlyproject.Feature.user.domain.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userId: String): User? {
        return try {
            userRepository.getUserById(userId) // Call to repository to get user data
        } catch (e: Exception) {
            Log.e("GetUserUseCase", "Error fetching user data: ${e.message}")
            null  // Return null if there's an error
        }
    }
}
