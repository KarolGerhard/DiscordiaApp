package br.com.akgs.discordia.data.remote.firebase

interface FirebaseAuthenticator {
    fun getInstance()
    fun createUser(email: String, password: String)
    fun signIn(email: String, password: String)
    fun signOut()
    fun currentUser(): String
}