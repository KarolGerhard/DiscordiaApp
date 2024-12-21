import android.app.Application
import androidx.lifecycle.Observer
import br.com.akgs.discordia.domain.entities.Expense
import br.com.akgs.discordia.domain.usecases.auth.AuthUseCase
import br.com.akgs.discordia.domain.usecases.expense.ExpenseUseCase
import br.com.akgs.discordia.ui.home.HomeViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val authUseCase: AuthUseCase = mockk(relaxed = true)
    private val expenseUseCase: ExpenseUseCase = mockk(relaxed = true)
    private lateinit var homeViewModel: HomeViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        homeViewModel = HomeViewModel(authUseCase, expenseUseCase)
    }

    @Test
    fun loadUserExpenses() = runTest {

          val expense =  Expense(
                "1",
                "Item1",
                "Mercado",
                150.0,
                "Pix",
                "User1"
            )

        homeViewModel.loadUserExpenses()
        coEvery { expenseUseCase.createExpense(expense) }
        assertEquals(null, homeViewModel.expenses.value?.size)
    }

    @Test
    fun divideExpense() {
        val persons = 2
        val valueExpense = 100.0
        val result = homeViewModel.divideExpense(persons, valueExpense)
        50.0 == result
    }
}