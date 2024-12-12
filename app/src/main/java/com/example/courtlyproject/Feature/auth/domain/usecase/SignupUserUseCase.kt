package com.example.courtlyproject.Feature.auth.domain.usecase

import com.example.courtlyproject.Feature.user.domain.model.User
import com.example.courtlyproject.Feature.auth.domain.repository.AuthRepository
import com.example.courtlyproject.util.AppResult

class SignupUserUseCase (private val authRepository: AuthRepository){
    suspend operator fun invoke(user: User): AppResult<Boolean> {
        return authRepository.signupUser(user)
    }
}