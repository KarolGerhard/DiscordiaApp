package br.com.akgs.discordia.data.remote.firebase
import com.google.firebase.firestore.FirebaseFirestore


class FirebaseDatabaseImpl: FirebaseDatabase {
    private lateinit var db: FirebaseFirestore


    override fun getInstance(){
       db =  FirebaseFirestore.getInstance()
    }

    override fun createDocument(document: String){
        db.collection("EXPENSES").add(document)
    }

    override fun getDocument(document: String){
        db.collection("EXPENSES").document(document).get()
    }

    override fun updateDocument(document: String){
        db.collection("EXPENSES").document(document).get()
    }

    override fun deleteDocument(document: String){
        db.collection("EXPENSES").document(document).delete()
    }
}