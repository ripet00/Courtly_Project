package com.example.courtlyproject.Feature.user.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.courtlyproject.Feature.user.domain.model.User
import com.example.courtlyproject.Feature.user.domain.usecase.GetUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserProfileViewModel(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {
    private val _userState = MutableStateFlow<User?>(null)
    val userState: StateFlow<User?> = _userState

    fun fetchUser(userId: String) {
        viewModelScope.launch {
            try {
                // Fetch the user data
                val user = getUserUseCase(userId)
                if (user != null) {
                    _userState.value = user  // Update userState if data is available
                } else {
                    _userState.value = null // Handle the case where user doesn't exist
                    Log.d("UserProfileViewModel", "User not found for UID: $userId")
                }
            } catch (e: Exception) {
                _userState.value = null  // Set null or handle error state
                Log.e("UserProfileViewModel", "Error fetching user: ${e.message}")
            }
        }
    }
}