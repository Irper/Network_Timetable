package ru.vovan.networktimetable

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.FormBody
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.vovan.networktimetable.network.network.TimetableAPI
import ru.vovan.networktimetable.network.network.TimetableNetworkObject
import ru.vovan.networktimetable.network.repository.TimetableRepositoryImpl
import ru.vovan.networktimetable.ui.component.Timetable
import ru.vovan.networktimetable.ui.theme.NetworkTimetableTheme

class MainActivity : ComponentActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            var b = FormBody.Builder().add("AudID", "101").build()

            try {
                GlobalScope.launch {
                    Log.d(TAG, TimetableNetworkObject.retrofitTimetable.create(TimetableAPI::class.java).gt(b).string())
                }
            } catch (e: Exception){
                e.printStackTrace()
            }

        enableEdgeToEdge()
        setContent {
            NetworkTimetableTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
    companion object{
        private val TAG = MainActivity::class.java.simpleName
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    Text("Hello, world!")
}
