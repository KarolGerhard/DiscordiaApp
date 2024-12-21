package br.com.akgs.discordia.ui.di

import br.com.akgs.discordia.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel { HomeViewModel(
        get(),
        get()
    ) }


}