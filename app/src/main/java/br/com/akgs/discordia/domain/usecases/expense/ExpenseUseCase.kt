package br.com.akgs.discordia.domain.usecases.expense

interface ExpenseUseCase {
    fun createExpense()
    fun updateExpense()
    fun deleteExpense()
    fun getExpense()
}