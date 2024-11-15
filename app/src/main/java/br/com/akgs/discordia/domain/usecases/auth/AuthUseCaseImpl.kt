package br.com.akgs.discordia.domain.usecases.auth

import br.com.akgs.discordia.data.auth.AuthRepository

class AuthUseCaseImpl(private val authRepository: AuthRepository) : AuthUseCase {
    override fun login(email: String, password: String) {
        authRepository.login(email, password)
    }

    override fun register(email: String, password: String) {
        authRepository.register(email, password)
    }

    override fun logout() {
        authRepository.logout()
    }

    override fun currentUser() {
        authRepository.currentUser()
    }

}