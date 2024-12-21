package br.com.akgs.discordia.ui.di

import br.com.akgs.discordia.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {
    viewModel {
        LoginViewModel(
            get()
        )
    }
}