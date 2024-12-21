package br.com.akgs.discordia

import android.app.Application
import br.com.akgs.discordia.data.di.appDataModule
import br.com.akgs.discordia.domain.di.domainModule
import br.com.akgs.discordia.ui.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ApplicationActivity : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@ApplicationActivity)
            modules(
                appDataModule + domainModule + uiModule
            )
        }
    }
}