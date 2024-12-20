package com.example.courtlyproject.Feature.auth.domain.usecase

import com.example.courtlyproject.Feature.auth.domain.repository.AuthRepository
import com.example.courtlyproject.util.AppResult

class LoginWithEmailUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): AppResult<Boolean> {
        return authRepository.loginWithEmail(email, password)
    }
}