package ru.vovan.networktimetable.network.network

import retrofit2.Retrofit

object TimetableNetworkObject {
    @Volatile
    var retrofitTimetable: Retrofit = Retrofit.Builder()
        .baseUrl("https://dvgups.ru")
        .build()
}