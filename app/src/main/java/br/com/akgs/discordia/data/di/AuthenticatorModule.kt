package br.com.akgs.discordia.data.di

import br.com.akgs.discordia.data.auth.AuthRepository
import br.com.akgs.discordia.data.auth.AuthRepositoryImpl
import org.koin.dsl.module
import javax.annotation.processing.Generated

@Generated
val authenticatorModule = module {
    single { get<AuthRepositoryImpl>() }
    single { get<AuthRepository>() }
}