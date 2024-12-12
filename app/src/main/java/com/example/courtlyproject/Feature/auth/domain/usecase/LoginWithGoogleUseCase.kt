package com.example.courtlyproject.Feature.auth.domain.usecase

import com.example.courtlyproject.Feature.auth.domain.repository.AuthRepository
import com.example.courtlyproject.util.AppResult

class LoginWithGoogleUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(idToken: String): AppResult<Boolean> {
        return authRepository.loginWithGoogle(idToken)
    }
}