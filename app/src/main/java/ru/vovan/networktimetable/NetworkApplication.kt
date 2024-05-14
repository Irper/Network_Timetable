package ru.vovan.networktimetable

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import ru.vovan.networktimetable.di.dataModule

class NetworkApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        GlobalContext.startKoin {
            androidLogger()
            androidContext(this@NetworkApplication)
            modules(dataModule)
        }
    }
}