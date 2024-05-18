package ru.vovan.networktimetable.network.network

import retrofit2.http.GET
import retrofit2.http.POST
import ru.vovan.networktimetable.network.model.Timetable

interface TimetableAPI {
    @POST("index.php?Itemid=1246&option=com_timetable&view=newtimetable")
    suspend fun getAllTimetable() : Timetable
}