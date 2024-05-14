

import retrofit2.http.GET
import ru.vovan.networktimetable.network.model.Timetable

interface TimetableAPI {
    @GET("index.php?Itemid=1246&option=com_timetable&view=newtimetable")
    suspend fun getAllTimetable() : Timetable
}