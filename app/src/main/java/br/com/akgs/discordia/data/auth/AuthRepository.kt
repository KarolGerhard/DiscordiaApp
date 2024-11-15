package br.com.akgs.discordia.data.auth

interface AuthRepository {
    fun login(email: String, password: String)
    fun register(email: String, password: String)
    fun logout()
    fun currentUser(): String
}