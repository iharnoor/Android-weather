package com.weather.forecast.clearsky.mainscreen.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.weather.forecast.clearsky.mainscreen.viewmodel.MainViewModel
import com.weather.forecast.clearsky.network.ResultData
import com.weather.forecast.clearsky.ui.theme.ClearSkyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getWeatherData("Amsterdam").observe(this) {
            when (it) {
                is ResultData.Success -> {
                    Log.i("harry", "" + it.toString())
                    it.data?.let { it1 -> Log.d("TAG", "onCreate: $it1") }
                }

                is ResultData.Failed -> {
                    Log.d("TAG", "onCreate: failed ${it.message}")
                }

                is ResultData.Loading -> {
                    Log.d("TAG", "onCreate: Loading")
                }
            }
        }

        setContent {
            ClearSkyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClearSkyTheme {
        Greeting("Android")
    }
}