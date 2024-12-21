package br.com.akgs.discordia.ui.expense

import androidx.lifecycle.ViewModel
import br.com.akgs.discordia.data.remote.entities.Usuario
import br.com.akgs.discordia.domain.entities.Expense
import br.com.akgs.discordia.domain.usecases.auth.AuthUseCase
import br.com.akgs.discordia.domain.usecases.expense.ExpenseUseCase

class AddExpenseViewModel(
    private val expenseUseCase: ExpenseUseCase,
    private val authUseCase: AuthUseCase
) : ViewModel() {

    fun addExpense(expense: Expense): String {
        return try {
            expenseUseCase.createExpense(expense)
            "Success"
        } catch (e: Exception) {
            "Failure: ${e.message}"
        }
    }

    fun getUser(): Usuario {
        return authUseCase.currentUser()
    }
}