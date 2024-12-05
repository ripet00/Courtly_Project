package com.example.courtlyproject.auth.data.repository

import com.example.courtlyproject.auth.domain.model.User
import com.example.courtlyproject.auth.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import com.example.courtlyproject.util.AppResult

class AuthRepositoryImplemen(firebaseAuth: FirebaseAuth, firestore: FirebaseFirestore) : AuthRepository {

    private val auth = FirebaseAuth.getInstance()
    private val firestore = FirebaseFirestore.getInstance()

    // Signup User
    override suspend fun signupUser(user: User): AppResult<Boolean> {
        return try {
            val authResult = auth.createUserWithEmailAndPassword(user.email, user.password).await()
            val uid = authResult.user?.uid ?: throw Exception("User ID is null")
            // Simpan data user di Firestore
            val userData = mapOf(
                "username" to user.username,
                "email" to user.email,
                "phone" to user.nomorHp
            )
            firestore.collection("user").document(uid).set(userData).await()

            AppResult.Success(true) // Gunakan Result buatan sendiri
        } catch (e: Exception) {
            AppResult.Failure(e) // Gunakan Result buatan sendiri
        }
    }

    // Login dengan Email dan Password
    override suspend fun loginWithEmail(email: String, password: String): AppResult<Boolean> {
        return try {
            auth.signInWithEmailAndPassword(email, password).await()
            AppResult.Success(true) // Gunakan Result buatan sendiri
        } catch (e: Exception) {
            AppResult.Failure(e) // Gunakan Result buatan sendiri
        }
    }

    // Login dengan Google
    override suspend fun loginWithGoogle(idToken: String): AppResult<Boolean> {
        return try {
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            auth.signInWithCredential(credential).await()
            AppResult.Success(true) // Gunakan Result buatan sendiri
        } catch (e: Exception) {
            AppResult.Failure(e) // Gunakan Result buatan sendiri
        }
    }
}
