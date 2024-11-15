package br.com.akgs.discordia.data.remote.firebase

interface FirebaseDatabase {
    fun getInstance()
    fun createDocument(document: String)
    fun updateDocument(document: String)
    fun deleteDocument(document: String)
    fun getDocument(document: String)
}