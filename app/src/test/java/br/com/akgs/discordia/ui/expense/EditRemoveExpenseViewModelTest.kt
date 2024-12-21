package br.com.akgs.discordia.ui.expense

import br.com.akgs.discordia.domain.entities.Expense
import br.com.akgs.discordia.domain.usecases.auth.AuthUseCase
import br.com.akgs.discordia.domain.usecases.expense.ExpenseUseCase
import io.mockk.MockKAnnotations
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class EditRemoveExpenseViewModelTest{

    private val expenseUseCase: ExpenseUseCase = mockk(relaxed = true)
    private lateinit var viewModel: EditRemoveExpenseViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = EditRemoveExpenseViewModel(expenseUseCase)
    }

        @Test
        fun `removeExpense should return Success`(){
            val expense = Expense(
                "1",
                "Item1",
                "Mercado",
                150.0,
                "Pix",
                "User1"
            )
            val result = viewModel.removeExpense(expense)
            assertEquals("Success", result)
        }

        @Test
        fun `editExpense should return Success`(){
            val expense = Expense(
                "1",
                "Item1",
                "Mercado",
                150.0,
                "Pix",
                "User1"
            )
            val result = viewModel.editExpense(expense)
            assertEquals("Success", result)
        }
}