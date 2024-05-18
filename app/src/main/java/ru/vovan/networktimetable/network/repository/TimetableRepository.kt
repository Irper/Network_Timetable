package ru.vovan.networktimetable.network.repository

import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import ru.vovan.networktimetable.network.model.Timetable

interface TimetableRepository {
    fun getAllTimetable(): Flow<String>

}