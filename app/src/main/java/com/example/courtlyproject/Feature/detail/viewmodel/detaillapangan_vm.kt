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

class detaillapangan_vm(): ViewModel() {
    val state = mutableStateOf(detaillapangan())


    fun getDetail(lapanganId: String) {
        viewModelScope.launch {
            state.value = getDetailFromFireStore(lapanganId = lapanganId)
        }
    }

    suspend fun getDetailFromFireStore(lapanganId: String):detaillapangan {

        val db = FirebaseFirestore.getInstance()
        var detail = detaillapangan()

        try {
            val result = db.collection("detail")
                .document(lapanganId)
                .get()
                .await()

            if (result.exists()) {
                // jika dokumen ditemukan, konversikan menjadi objek detail lapangan
                detail = result.toObject(detaillapangan::class.java) ?: detaillapangan()
            } else {
                // jika dokumen tidak ditemukan
                Log.d("detaillapangan", "lapangan dengan ID : $lapanganId  tidak ditemukan")
            }
            Log.d("detaillapangan", "getDetailFromFireStore: $detail")

        } catch (e:FirebaseFirestoreException) {
            Log.d("error", "getDetailFromFireStore: $e")
        }

        return detail
    }
}

