package ru.vovan.networktimetable.network.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.FormBody
import retrofit2.Retrofit
import ru.vovan.networktimetable.network.network.TimetableAPI

class TimetableRepositoryImpl(private val retrofit: Retrofit) : TimetableRepository {
    override fun getAllTimetable(): Flow<String> =
        flow {
            val response = retrofit.create(TimetableAPI::class.java).gt( FormBody.Builder().add("AudID", "101").build())
            emit(response.toString())
        }
}