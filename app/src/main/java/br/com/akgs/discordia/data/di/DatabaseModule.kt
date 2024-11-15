package br.com.akgs.discordia.data.di

import br.com.akgs.discordia.data.remote.firebase.FirebaseDatabaseImpl
import org.koin.dsl.module
import javax.annotation.processing.Generated

@Generated
val databaseModule = module {
    single {get<FirebaseDatabaseImpl>()}
}