package ru.vovan.networktimetable.network.repository

import android.util.Log
import ru.vovan.networktimetable.network.network.TimetableAPI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.FormBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import ru.vovan.networktimetable.network.model.Timetable

class TimetableRepositoryImpl(private val retrofit: Retrofit) : TimetableRepository {
    override fun getAllTimetable(): Flow<String> =
        flow {
            var response = retrofit.create(TimetableAPI::class.java).getAllTimetable( FormBody.Builder().add("AudID", "101").build())

            Log.d(TAG, response)
            emit(response)
        }


    companion object{
        private val TAG = TimetableRepositoryImpl::class.java.simpleName
    }
}