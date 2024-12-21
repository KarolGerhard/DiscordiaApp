package br.com.akgs.discordia.domain.usecases.auth

import br.com.akgs.discordia.data.remote.entities.Usuario
import br.com.akgs.discordia.data.remote.firebase.FirebaseAuthenticator

class AuthUseCaseImpl(private val authRepository: FirebaseAuthenticator) : AuthUseCase {
    override fun login(email: String, password: String) {
        authRepository.signIn(email, password)
    }

    override suspend fun register(email: String, password: String) {
        authRepository.createUser(email, password)
    }

    override fun logout() {
        authRepository.signOut()
    }

    override fun currentUser(): Usuario {
        return authRepository.currentUser()
    }
}