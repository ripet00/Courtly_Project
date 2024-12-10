package com.example.courtlyproject.di

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.example.courtlyproject.Feature.auth.data.repository.AuthRepositoryImplemen
import com.example.courtlyproject.Feature.auth.domain.repository.AuthRepository
import com.example.courtlyproject.Feature.auth.domain.usecase.LoginWithEmailUseCase
import com.example.courtlyproject.Feature.auth.domain.usecase.LoginWithGoogleUseCase
import com.example.courtlyproject.Feature.auth.domain.usecase.SignupUserUseCase
import com.example.courtlyproject.Feature.user.data.repository.UserRepositoryImpl
import com.example.courtlyproject.Feature.user.domain.repository.UserRepository
import com.example.courtlyproject.Feature.user.domain.usecase.GetUserUseCase
import com.example.courtlyproject.Feature.user.presentation.viewModel.UserProfileViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @SuppressLint("StaticFieldLeak")
    private val firestore = FirebaseFirestore.getInstance()

    private val userRepository: UserRepository = UserRepositoryImpl(firestore)
    private val getUserUseCase = GetUserUseCase(userRepository)

    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFirestore(): FirebaseFirestore = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun provideAuthRepository(
        firebaseAuth: FirebaseAuth,
        firestore: FirebaseFirestore
    ): AuthRepository {
        return AuthRepositoryImplemen(firebaseAuth, firestore)
    }

    @Provides
    @Singleton
    fun provideLoginWithEmailUseCase(authRepository: AuthRepository): LoginWithEmailUseCase {
        return LoginWithEmailUseCase(authRepository)
    }

    @Provides
    @Singleton
    fun provideLoginWithGoogleUseCase(authRepository: AuthRepository): LoginWithGoogleUseCase {
        return LoginWithGoogleUseCase(authRepository)
    }

    @Provides
    @Singleton
    fun provideSignupUserUseCase(authRepository: AuthRepository): SignupUserUseCase {
        return SignupUserUseCase(authRepository)
    }


    @Provides
    @Singleton
    fun provideUserProfileViewModel(): UserProfileViewModel {
        return UserProfileViewModel(getUserUseCase)
    }
}
