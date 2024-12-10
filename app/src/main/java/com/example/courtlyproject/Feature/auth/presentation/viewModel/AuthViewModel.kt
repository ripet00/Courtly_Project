package com.example.courtlyproject.Feature.auth.presentation.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.courtlyproject.Feature.user.domain.model.User
import com.example.courtlyproject.Feature.auth.domain.usecase.LoginWithEmailUseCase
import com.example.courtlyproject.Feature.auth.domain.usecase.LoginWithGoogleUseCase
import com.example.courtlyproject.Feature.auth.domain.usecase.SignupUserUseCase
import com.example.courtlyproject.util.AppResult
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginWithEmailUseCase: LoginWithEmailUseCase,
    private val loginWithGoogleUseCase: LoginWithGoogleUseCase,
    private val signupUserUseCase: SignupUserUseCase
) : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _authState = MutableStateFlow<AuthState>(AuthState.Idle)
    val authState: StateFlow<AuthState> get() = _authState

    // Login with Email
    fun loginWithEmail(email: String, password: String) {
        _authState.value = AuthState.Loading
        viewModelScope.launch {
            val result = loginWithEmailUseCase(email, password)
            _authState.value = if (result is AppResult.Success) {
                AuthState.Authenticated
            } else {
                AuthState.Error((result as AppResult.Failure).exception?.message ?: "Login failed")
            }
        }
    }

    // Login with Google
    fun loginWithGoogle(idToken: String) {
        _authState.value = AuthState.Loading
        viewModelScope.launch {
            val result = loginWithGoogleUseCase(idToken)
            _authState.value = if (result is AppResult.Success) {
                AuthState.Authenticated
            } else {
                AuthState.Error(
                    (result as AppResult.Failure).exception?.message ?: "Google login failed"
                )
            }
        }
    }

    // Signup User
    fun signupUser(user: User) {
        if (user.username.isEmpty() || user.email.isEmpty() || user.password.isEmpty() || user.repeatPassword.isEmpty() || user.nomorHp.isEmpty()) {
            _authState.value = AuthState.Error("Semua field harus diisi")
            return
        }
        _authState.value = AuthState.Loading
        viewModelScope.launch {
            val result = signupUserUseCase(user)
            _authState.value = if (result is AppResult.Success) {
                AuthState.UnAuthenticated
            } else {
                AuthState.Error((result as AppResult.Failure).exception?.message ?: "Signup failed")
            }
        }
    }

    fun signout(){
        auth.signOut()
        _authState.value = AuthState.UnAuthenticated
    }
}

sealed class AuthState {
    data object Idle : AuthState()
    data object Loading : AuthState()
    data object Authenticated : AuthState()
    data object UnAuthenticated : AuthState()
    data class Error(val message: String) : AuthState()
}
