package ru.vovan.networktimetable.network.network

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.POST

interface TimetableAPI {
    @POST("index.php?Itemid=1246&option=com_timetable&view=newtimetable/")
    suspend fun gt(@Body AudID:RequestBody) : ResponseBody
}