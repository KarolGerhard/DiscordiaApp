package br.com.akgs.discordia.data.remote.firebase
import com.google.firebase.auth.FirebaseAuth


class FirebaseAuthImpl: FirebaseAuthenticator {
    private lateinit var auth: FirebaseAuth

    override fun getInstance(){
       auth = FirebaseAuth.getInstance()
    }

    override fun createUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                 task.result?.user?.uid
            } else {
                task.exception?.message
            }
        }
    }

    override fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                task.result?.user?.uid
                // Login success
            } else {
                task.exception?.message
            }
        }
    }

    override fun signOut() {
        auth.signOut()
    }

    override fun currentUser(): String {
        val authenticatedUser = auth.currentUser
        return authenticatedUser?.email ?: ""
    }
}