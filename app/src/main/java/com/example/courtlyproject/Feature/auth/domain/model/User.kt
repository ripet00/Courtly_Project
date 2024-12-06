package com.example.courtlyproject.auth.domain.model

data class User(
    val username : String,
    val email : String,
    val password : String,
    val repeatPassword : String,
    val nomorHp : String
)
