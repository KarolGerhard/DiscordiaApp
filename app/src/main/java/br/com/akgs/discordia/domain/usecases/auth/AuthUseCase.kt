package br.com.akgs.discordia.domain.usecases.auth

import br.com.akgs.discordia.data.remote.entities.Usuario

interface AuthUseCase {
    fun login(email: String, password: String)
    suspend fun register(email: String, password: String)
    fun logout()
    fun currentUser(): Usuario
}