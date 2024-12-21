package br.com.akgs.discordia.data.remote.firebase

import android.content.ContentValues.TAG
import android.util.Log
import br.com.akgs.discordia.domain.entities.Expense
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class FirebaseDatabaseImpl : FirebaseDatabase {
    val db = Firebase.firestore

    override fun createDocument(document: Expense): String {
        var mensage: String = ""
        db.collection("EXPENSES").add(document).addOnSuccessListener { documentReference ->
            documentReference.id
            mensage = "Success"
        }.addOnFailureListener { expense ->
            mensage = expense.message.toString()
            Log.w("TAG", "Error adding document", expense)
        }
        return mensage
    }

    override fun getDocument(document: String) {
        db.collection("EXPENSES").document(document).get()
    }

    override fun updateDocument(document: Expense) {
        db.collection("EXPENSES").document(document.id).set(document)
            .addOnSuccessListener {
                Log.d(TAG, "DocumentSnapshot successfully updated!")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error updating document", e)
            }
    }

    override fun deleteDocument(document: Expense) {
        db.collection("EXPENSES").document(document.id).delete()
    }

    override suspend fun getUserExpenses(userId: String): ArrayList<Expense> {
        val expenses = ArrayList<Expense>()
        try {
            val result = db.collection("EXPENSES")
                .whereEqualTo("userId", userId)
                .get()
                .await()

            for (document in result.documents) {
                val expense = Expense(
                    id = document.id,
                    userId = document.getString("userId") ?: "",
                    itemName = document.getString("itemName") ?: "",
                    value = document.getDouble("value") ?: 0.0,
                    paymentMethod = document.getString("paymentMethod") ?: "",
                    peoplePaid = document.getString("peoplePaid") ?: ""
                )
                expenses.add(expense)
            }
        } catch (exception: Exception) {
            Log.e("FirebaseDatabaseImpl", "Error getting user expenses", exception)
        }
        return expenses
    }
}