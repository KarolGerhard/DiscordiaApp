package br.com.akgs.discordia.ui.expense

import MainDispatcherRule
import br.com.akgs.discordia.domain.entities.Expense
import br.com.akgs.discordia.domain.usecases.auth.AuthUseCase
import br.com.akgs.discordia.domain.usecases.expense.ExpenseUseCase
import br.com.akgs.discordia.ui.home.HomeViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.TestResult
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AddExpenseViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val authUseCase: AuthUseCase = mockk(relaxed = true)
    private val expenseUseCase: ExpenseUseCase = mockk(relaxed = true)
    private lateinit var addViewModel: AddExpenseViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        addViewModel = AddExpenseViewModel(expenseUseCase, authUseCase)
    }

    @Test
    fun addExpense() = runTest {
        val expense = Expense(
            "1",
            "Item1",
            "Mercado",
            150.0,
            "Pix",
            "User1"
        )

        addViewModel.addExpense(expense)
        coEvery { expenseUseCase.createExpense(expense) }
        assertEquals(null, addViewModel.getUser().id)
    }
}