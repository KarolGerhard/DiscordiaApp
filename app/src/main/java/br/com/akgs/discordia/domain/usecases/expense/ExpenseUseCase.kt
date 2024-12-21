package br.com.akgs.discordia.domain.usecases.expense

import br.com.akgs.discordia.domain.entities.Expense

interface ExpenseUseCase {
    fun createExpense(expense: Expense): String
    fun updateExpense(expense: Expense)
    fun deleteExpense(expense: Expense)
    suspend fun getExpense(id: String)
    suspend fun getUserExpenses(userId: String): ArrayList<Expense>
    fun calculateTotalExpenses(expenses: ArrayList<Expense>): Double
    fun divideExpense(persons: Int, valueExpense: Double): Double
}