package br.com.akgs.discordia.ui.di

import br.com.akgs.discordia.ui.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val profileModule = module {
    viewModel {
        ProfileViewModel(
            get(),
        )
    }
}