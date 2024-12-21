package br.com.akgs.discordia.data.remote.firebase

import br.com.akgs.discordia.data.remote.entities.Usuario

interface FirebaseAuthenticator {

    fun createUser(email: String, password: String)
    fun signIn(email: String, password: String)
    fun signOut()
    fun currentUser(): Usuario
}