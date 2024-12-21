package br.com.akgs.discordia.ui.profile

import androidx.lifecycle.ViewModel
import br.com.akgs.discordia.domain.usecases.auth.AuthUseCase

class ProfileViewModel(private val authUseCase: AuthUseCase) : ViewModel() {

    fun signOut() {
        authUseCase.logout()
    }

    fun currentUser() = authUseCase.currentUser()

}