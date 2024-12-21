package br.com.akgs.discordia.domain.usecases.expense

import MainDispatcherRule
import br.com.akgs.discordia.domain.entities.Expense
import io.mockk.MockKAnnotations
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ExpenseUseCaseImplTest{

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()
    private val expenseUseCase: ExpenseUseCase = mockk(relaxed = true)

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun createExpense() {
        val expense = Expense(
            "1",
            "Item1",
            "Mercado",
            150.0,
            "Pix",
            "User1"
        )

        expenseUseCase.createExpense(expense)
    }

    @Test
    fun removeExpense() {
        val expense = Expense(
            "1",
            "Item1",
            "Mercado",
            150.0,
            "Pix",
            "User1"
        )

        expenseUseCase.deleteExpense(expense)
    }

}