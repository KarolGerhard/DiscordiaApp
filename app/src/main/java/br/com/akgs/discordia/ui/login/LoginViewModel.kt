package br.com.akgs.discordia.ui.login

import androidx.lifecycle.ViewModel
import br.com.akgs.discordia.domain.usecases.auth.AuthUseCase

class LoginViewModel(
    private val authUseCase: AuthUseCase
) : ViewModel() {

    fun login(email: String, password: String): String {
        return try {
            authUseCase.login(email, password)
            "Success"
        } catch (e: Exception) {
            "Failure: ${e.message}"
        }
    }

    fun currentUser() {
        authUseCase.currentUser()
    }
}