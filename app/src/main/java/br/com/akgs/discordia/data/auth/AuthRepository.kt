package br.com.akgs.discordia.data.auth

import br.com.akgs.discordia.data.remote.entities.Usuario

interface AuthRepository {
    fun login(email: String, password: String)
    fun register(email: String, password: String)
    fun logout()
    fun currentUser(): Usuario
}