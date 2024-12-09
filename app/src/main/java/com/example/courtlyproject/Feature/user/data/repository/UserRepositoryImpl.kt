package com.example.courtlyproject.Feature.user.data.repository

import android.util.Log
import com.example.courtlyproject.Feature.user.domain.model.User
import com.example.courtlyproject.Feature.user.domain.repository.UserRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : UserRepository {
    override suspend fun getUserById(userId: String): User? {
        val documentSnapshot = firestore.collection("user")
            .document(userId)
            .get()
            .await() // Use coroutine to wait for Firestore query result

        return if (documentSnapshot.exists()) {
            documentSnapshot.toObject(User::class.java) // Return User data if found
        } else {
            Log.d("UserRepository", "No user found for UID: $userId")
            null // Return null if user is not found
        }
    }
}