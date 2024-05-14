package ru.vovan.networktimetable.network.repository

import ru.vovan.networktimetable.network.network.TimetableAPI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import ru.vovan.networktimetable.network.model.Timetable

class TimetableRepositoryImpl(private val retrofit: Retrofit): TimetableRepository {
    override fun getAllTimetable(): Flow<Timetable> =
        flow { emit(retrofit.create(TimetableAPI::class.java).getAllTimetable()) }
}