package br.com.akgs.discordia.data.remote.firebase
import br.com.akgs.discordia.data.remote.entities.Usuario
import com.google.firebase.auth.FirebaseAuth


class FirebaseAuthImpl: FirebaseAuthenticator {
    private var auth = FirebaseAuth.getInstance()

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

    override fun currentUser(): Usuario {
        val user = auth.currentUser
        return if (user != null) {
            Usuario(id = user.uid, email = user.email, nome = user.displayName, )
        }else{
            Usuario("","","")
        }
    }
}