package ru.vovan.networktimetable.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.koinViewModel
import ru.vovan.networktimetable.viewmodel.DataViewModel

@Composable
fun Timetable(dataViewModel: DataViewModel = koinViewModel()){
    val stringLesson by dataViewModel.getAllTimetable().collectAsState(Timetable())
    Text(
        text = stringLesson.toString()
    )
}