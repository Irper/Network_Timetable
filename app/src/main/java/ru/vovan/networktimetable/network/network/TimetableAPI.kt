package ru.vovan.networktimetable.network.network

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import ru.vovan.networktimetable.network.model.Timetable

interface TimetableAPI {
    @POST("index.php?Itemid=1246&option=com_timetable&view=newtimetable/")
    suspend fun getAllTimetable(@Body AudID:RequestBody) : String
    @POST("index.php?Itemid=1246&option=com_timetable&view=newtimetable/")
    suspend fun gt(@Body AudID:RequestBody) : ResponseBody
}