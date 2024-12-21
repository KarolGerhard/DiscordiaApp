package br.com.akgs.discordia.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import br.com.akgs.discordia.domain.entities.Expense
import br.com.akgs.discordia.domain.usecases.auth.AuthUseCase
import br.com.akgs.discordia.domain.usecases.expense.ExpenseUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val authUseCase: AuthUseCase,
    private val expenseUseCase: ExpenseUseCase
) : ViewModel() {

    private val _expenses = MutableLiveData<ArrayList<Expense>>()
    val expenses: LiveData<ArrayList<Expense>> get() = _expenses

    val totalExpenses: LiveData<Double> = _expenses.map { expenses ->
        expenseUseCase.calculateTotalExpenses(expenses)
    }

    init {
        loadUserExpenses()
    }

    fun loadUserExpenses() {
        viewModelScope.launch {
            val userId = authUseCase.currentUser().id
            val userExpenses = expenseUseCase.getUserExpenses(userId)
            _expenses.postValue(userExpenses)
            Log.d("HomeViewModel", "getExpenses: $userExpenses")
        }
    }

    fun divideExpense(persons: Int, valueExpense: Double): Double {
        return expenseUseCase.divideExpense(persons, valueExpense)
    }
}