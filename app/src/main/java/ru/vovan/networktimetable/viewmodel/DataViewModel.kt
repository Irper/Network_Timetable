package ru.vovan.networktimetable.viewmodel

import TimetableRepository
import androidx.lifecycle.ViewModel

class DataViewModel(
    private val timetableRepository: TimetableRepository,
): ViewModel() {
    fun getAllTimetable() = timetableRepository.getAllTimetable()
}