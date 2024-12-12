package com.example.courtlyproject.Feature.auth.data.repository

import com.example.courtlyproject.Feature.user.domain.model.User
import com.example.courtlyproject.Feature.auth.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import com.example.courtlyproject.util.AppResult
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.firestore.FirebaseFirestoreException

class AuthRepositoryImplemen(firebaseAuth: FirebaseAuth, firestore: FirebaseFirestore) :
    AuthRepository {

    private val auth = FirebaseAuth.getInstance()
    private val firestore = FirebaseFirestore.getInstance()

    // Signup User
    override suspend fun signupUser(user: User): AppResult<Boolean> {
        return try {
            // Proses signup menggunakan Firebase Authentication
            val authResult = auth.createUserWithEmailAndPassword(user.email, user.password).await()

            // Ambil UID dari hasil auth
            val uid = authResult.user?.uid ?: throw Exception("User UID is null after signup")

            // Menyusun data pengguna untuk disimpan di Firestore
            val userData = mapOf(
                "username" to user.username,
                "email" to user.email,
                "nomorHp" to user.nomorHp
            )

            // Simpan data pengguna di Firestore
            firestore.collection("user").document(uid).set(userData).await()

            // Kembalikan hasil sukses
            AppResult.Success(true)
        } catch (e: FirebaseAuthException) {
            // Tangani error khusus Firebase Authentication
            AppResult.Failure(Exception("Firebase Authentication error: ${e.message}"))
        } catch (e: FirebaseFirestoreException) {
            // Tangani error khusus Firestore
            AppResult.Failure(Exception("Firestore error: ${e.message}"))
        } catch (e: Exception) {
            // Tangani error umum
            AppResult.Failure(e)
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
