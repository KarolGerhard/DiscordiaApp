package br.com.akgs.discordia.domain.di

import br.com.akgs.discordia.domain.usecases.auth.AuthUseCase
import br.com.akgs.discordia.domain.usecases.auth.AuthUseCaseImpl
import br.com.akgs.discordia.domain.usecases.expense.ExpenseUseCase
import br.com.akgs.discordia.domain.usecases.expense.ExpenseUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    factory<AuthUseCase> {
        AuthUseCaseImpl(
            authRepository = get(),
        )
    }

    factory<ExpenseUseCase> {
        ExpenseUseCaseImpl(
            db = get(),
        )
    }
}