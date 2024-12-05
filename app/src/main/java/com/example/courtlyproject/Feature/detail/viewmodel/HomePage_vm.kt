package com.example.courtlyproject.Feature.detail.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.courtlyproject.Feature.detail.model.detaillapangan
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject

class HomePage_vm: ViewModel()  {

    private val _stateLapangan = mutableStateOf<List<detaillapangan>>(emptyList()) // Menggunakan List<HomePage>
    val stateLapangan: List<detaillapangan>
        get() = _stateLapangan.value

    private val firestore = FirebaseFirestore.getInstance()

    init {
        Log.d("HomePage_vm", "init: ")
        getListLapangan()
    }

    fun getListLapangan() {
        firestore.collection("detail")
            .get() // Mengambil semua dokumen di koleksi "detail"
            .addOnSuccessListener { result ->
                if (result.isEmpty) {
                    // Tangani jika tidak ada data
                    return@addOnSuccessListener
                }

                // Mengambil semua dokumen dan mengonversinya ke dalam daftar objek HomePage
                val lapanganList = result.documents.mapNotNull { documentSnapshot ->
                    val id = documentSnapshot.id
                    val lapangan = documentSnapshot.toObject<detaillapangan>() // Mengonversi setiap dokumen menjadi objek HomePage

                    if (lapangan != null) {
                        lapangan.id = id
                    }
                    lapangan
                }

                Log.d("HomePage_vm", "getListLapangan: $lapanganList")

                // Mengupdate state dengan daftar lapangan yang diambil
                _stateLapangan.value = lapanganList // Menyimpan data dalam bentuk List<HomePage>
            }
            .addOnFailureListener { exception ->
                // Tangani error, misalnya tampilkan log error
                Log.e("FirestoreError", "Error getting documents: ", exception)
            }
    }

}
