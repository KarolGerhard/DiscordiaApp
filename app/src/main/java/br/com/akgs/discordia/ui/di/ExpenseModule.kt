package br.com.akgs.discordia.ui.di

import br.com.akgs.discordia.ui.expense.AddExpenseViewModel
import br.com.akgs.discordia.ui.expense.EditRemoveExpenseViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val expenseModule = module {
    viewModel { AddExpenseViewModel(get(), get()) }
    viewModel { EditRemoveExpenseViewModel(get()) }
}
