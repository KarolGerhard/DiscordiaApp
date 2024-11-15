package br.com.akgs.discordia.data.auth

import br.com.akgs.discordia.data.remote.firebase.FirebaseAuthenticator

class AuthRepositoryImpl(
    private val auth: FirebaseAuthenticator
): AuthRepository {
    override fun login(email: String, password: String) {
        auth.signIn(email, password)

    }

    override fun register(email: String, password: String){
        auth.createUser(email, password)
    }

    override fun logout() {
        auth.signOut()
    }

    override fun currentUser(): String {
        return auth.currentUser()
    }


}