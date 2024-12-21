package br.com.akgs.discordia.ui.expense

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.akgs.discordia.domain.entities.Expense
import br.com.akgs.discordia.domain.usecases.expense.ExpenseUseCase

class EditRemoveExpenseViewModel(
    private val expenseUseCase: ExpenseUseCase
) : ViewModel() {

    private val _expenses = MutableLiveData<Expense>()
    val expense: LiveData<Expense> get() = _expenses

    fun removeExpense(expense: Expense): String {
        return try {
            expenseUseCase.deleteExpense(expense)
            "Success"

        } catch (e: Exception) {
            "Failure: ${e.message}"
        }
    }

    fun editExpense(expense: Expense): String {
        return try {
            expenseUseCase.updateExpense(expense)
            "Success"
        } catch (e: Exception) {
            "Failure: ${e.message}"
        }
    }
}