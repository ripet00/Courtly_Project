package com.example.courtlyproject.Feature.detail.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.courtlyproject.Feature.detail.model.detaillapangan
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class detaillapangan_vm: ViewModel() {
    val state = mutableStateOf(detaillapangan())

    init {
        getDetail()
    }

    private fun getDetail() {
        viewModelScope.launch {
            state.value = getDetailFromFireStore()
        }
    }
}

suspend fun getDetailFromFireStore():detaillapangan {
    val db = FirebaseFirestore.getInstance()
    var detail = detaillapangan()

    try {
        db.collection("detail").get().await().map {
            val result = it.toObject(detaillapangan::class.java)
            detail = result
        }
    } catch (e:FirebaseFirestoreException) {
        Log.d("error", "getDetailFromFireStore: $e")
    }

    return detail
}