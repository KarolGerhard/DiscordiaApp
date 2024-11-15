package br.com.akgs.discordia.domain.usecases.expense

import br.com.akgs.discordia.data.remote.firebase.FirebaseDatabase

class ExpenseUseCaseImpl(private val db: FirebaseDatabase): ExpenseUseCase {
    override fun createExpense() {
        db.createDocument("EXPENSES")
    }

    override fun updateExpense() {
        db.updateDocument("EXPENSES")
    }

    override fun deleteExpense() {
        db.deleteDocument("EXPENSES")
    }

    override fun getExpense() {
        db.getDocument("EXPENSES")
    }

}