package br.com.akgs.discordia.domain.usecases.auth

interface AuthUseCase {
    fun login(email: String, password: String)
    fun register(email: String, password: String)
    fun logout()
    fun currentUser()
}