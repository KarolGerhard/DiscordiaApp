package br.com.akgs.discordia.data.di

import br.com.akgs.discordia.data.auth.AuthRepository
import br.com.akgs.discordia.data.auth.AuthRepositoryImpl
import br.com.akgs.discordia.data.remote.firebase.FirebaseAuthImpl
import br.com.akgs.discordia.data.remote.firebase.FirebaseAuthenticator
import org.koin.dsl.module

val authenticatorModule = module {
    single<FirebaseAuthenticator> { FirebaseAuthImpl() }
    single<AuthRepository> { AuthRepositoryImpl(get()) }
}
