package br.com.akgs.discordia.data.remote.firebase

import br.com.akgs.discordia.domain.entities.Expense

interface FirebaseDatabase {
    fun createDocument(document: Expense): String
    fun updateDocument(document: Expense)
    fun deleteDocument(document: Expense)
    fun getDocument(document: String)
    suspend fun getUserExpenses(userId: String): ArrayList<Expense>

}