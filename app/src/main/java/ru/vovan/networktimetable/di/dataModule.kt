package ru.vovan.networktimetable.di

import ru.vovan.networktimetable.network.repository.TimetableRepository
import ru.vovan.networktimetable.network.repository.TimetableRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.vovan.networktimetable.network.network.TimetableNetworkObject
import ru.vovan.networktimetable.viewmodel.DataViewModel


val dataModule = module {

    single<TimetableRepository> {
        TimetableRepositoryImpl(TimetableNetworkObject.retrofitTimetable)
    }

    viewModel { DataViewModel(get()) }
}