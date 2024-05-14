package ru.vovan.networktimetable.viewmodel

import ru.vovan.networktimetable.network.repository.TimetableRepository
import androidx.lifecycle.ViewModel

class DataViewModel(
    private val timetableRepository: TimetableRepository,
): ViewModel() {
    fun getAllTimetable() = timetableRepository.getAllTimetable()
}