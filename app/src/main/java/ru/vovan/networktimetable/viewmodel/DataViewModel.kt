package ru.vovan.networktimetable.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import okhttp3.FormBody
import org.jsoup.Jsoup
import ru.vovan.networktimetable.MainActivity
import ru.vovan.networktimetable.network.network.TimetableAPI
import ru.vovan.networktimetable.network.network.TimetableNetworkObject
import ru.vovan.networktimetable.network.repository.TimetableRepository

class DataViewModel(
    private val timetableRepository: TimetableRepository,
): ViewModel() {
    fun getAllTimetable() = timetableRepository.getAllTimetable()
    fun getTimetable(audienceNumber: String) {
        val b = FormBody.Builder().add("AudID", audienceNumber).build()

        try {
            viewModelScope.launch {
                val str = TimetableNetworkObject.retrofitTimetable.create(TimetableAPI::class.java).gt(b).string()

                //Паттерны
                val datePattern = "(0?[1-9]|[12][0-9]|3[01])[.](0?[1-9]|1[012])[.]([0-9][0-9][0-9][0-9])"
                val numberOfLessonPattern = "[0-9]"
                val itemTypePattern = "(Практика|Лабораторные работы|Лекции|Экзамен|Предэкзаменационные консультации)"
                val groupPattern = "([А-ЯЁ]+[0-9]+[А-ЯЁ]+)"
                val emailIconPattern = " ✉"

                // Парсинг Jsoup
                val doc = Jsoup.parse(str)
                //Заголовки
                val h3 = doc.getElementsByTag("h3")
                val tables = doc.getElementsByTag("table")

                for (i in 0 until h3.size)
                {
                    // Регулярное выраженния для даты
                    val patternRegexDate = Regex(datePattern)
                    val regexDate = patternRegexDate.find(h3[i].text())
                    if (regexDate != null) {
                        Log.d(TAG, regexDate.value)
                    }

                    // Все уроки на 1 день
                    val docTemp = Jsoup.parse(tables[i].toString())
                    val tr = docTemp.getElementsByTag("tr")
                    // Каждый урок по порядку
                    tr.forEach {trIt ->
                        val elementDiv = trIt.select("div")
                        val elementTd = trIt.select("td")

                        val tempNumberOfLesson = elementDiv.select("div").eq(1).text()
                        val tempItemLesson = elementDiv.select("div").eq(2).text()
                        val tempGroup = elementTd.select("td").eq(3).text()
                        val tempLecture = elementDiv.select("div").eq(4).text()

                        // Регулярное выраженния для номера занятия
                        val patternRegexNumberOfLesson = Regex(numberOfLessonPattern)
                        val regexNumberOfLesson = patternRegexNumberOfLesson.find(tempNumberOfLesson)
                        if (regexNumberOfLesson != null) {
                            Log.d(TAG, regexNumberOfLesson.value)
                        }
                        // Регулярное выраженния типа предмета и названия
                        val patternItemType = Regex(itemTypePattern)
                        val regexItemType = patternItemType.find(tempItemLesson)
                        if (regexItemType != null) {
                            Log.d(TAG, regexItemType.value)
                            val regexItemName = tempItemLesson.subSequence(regexItemType.range.last + 3, tempItemLesson.length)
                            Log.d(TAG, regexItemName.toString())
                        }
                        // Регулярное выраженния группы
                        val patternGroup = Regex(groupPattern)
                        val regexGroup = patternGroup.findAll(tempGroup)
                        var listGroup = ""
                        regexGroup.forEach { it ->
                            listGroup += if (regexGroup.last().value == it.value)
                                it.value
                            else
                                it.value + ", "
                        }
                        Log.d(TAG, listGroup)
                        // Регулярное выраженния имя преподавателя
                        val patternLecture = Regex(emailIconPattern)
                        val regexLecture = patternLecture.replace(tempLecture, "")
                        Log.d(TAG, regexLecture)

                    }

                }

            }
        } catch (e: Exception){
            e.printStackTrace()
        }

    }
    companion object{
        private val TAG = MainActivity::class.java.simpleName
    }
}