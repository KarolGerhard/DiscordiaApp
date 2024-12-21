package br.com.akgs.discordia.domain.usecases.expense

import br.com.akgs.discordia.data.remote.firebase.FirebaseDatabase
import br.com.akgs.discordia.domain.entities.Expense

class ExpenseUseCaseImpl(private val db: FirebaseDatabase) : ExpenseUseCase {
    override fun createExpense(expense: Expense): String {
        return db.createDocument(expense)
    }

    override  fun updateExpense(expense: Expense) {
        db.updateDocument(expense)
    }

    override  fun deleteExpense(expense: Expense) {
        db.deleteDocument(expense)
    }

    override suspend fun getExpense(id: String) {
          db.getDocument("EXPENSES")
    }


    override suspend fun getUserExpenses(userId: String):ArrayList<Expense> {
        return db.getUserExpenses(userId)
    }

    override fun calculateTotalExpenses(expenses: ArrayList<Expense>): Double {
      return expenses.sumOf { it.value ?: 0.0 }
    }

    override fun divideExpense(persons: Int, valueExpense: Double): Double {
        return valueExpense / persons
    }

}