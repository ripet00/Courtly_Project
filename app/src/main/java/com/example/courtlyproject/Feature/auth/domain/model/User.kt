package com.example.courtlyproject.Feature.auth.domain.model

data class User(
    val username : String,
    val email : String,
    val password : String,
    val repeatPassword : String,
    val nomorHp : String
)
