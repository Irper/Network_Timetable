
import kotlinx.coroutines.flow.Flow
import ru.vovan.networktimetable.network.model.Timetable

interface TimetableRepository {
    fun getAllTimetable(): Flow<Timetable>
}