package br.com.akgs.discordia.ui.login

import MainDispatcherRule
import br.com.akgs.discordia.domain.usecases.auth.AuthUseCase
import io.mockk.MockKAnnotations
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginViewModelTest{

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val authUseCase: AuthUseCase = mockk(relaxed = true)
   private lateinit var loginViewModel: LoginViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        loginViewModel = LoginViewModel(authUseCase)
    }

    @Test
    fun `login should return Success`(){
        val email = "email"
        val password = "password"
        val result = loginViewModel.login(email, password)
        assertEquals("Success", result)
    }

}