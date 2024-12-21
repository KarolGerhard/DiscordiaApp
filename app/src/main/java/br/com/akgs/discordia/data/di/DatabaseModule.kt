package br.com.akgs.discordia.data.di

import br.com.akgs.discordia.data.remote.firebase.FirebaseDatabase
import br.com.akgs.discordia.data.remote.firebase.FirebaseDatabaseImpl
import org.koin.dsl.module

val databaseModule = module {
    single<FirebaseDatabase> { FirebaseDatabaseImpl() }
}