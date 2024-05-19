package ru.vovan.networktimetable.network.repository

import kotlinx.coroutines.flow.Flow

interface TimetableRepository {
    fun getAllTimetable(): Flow<String>

}