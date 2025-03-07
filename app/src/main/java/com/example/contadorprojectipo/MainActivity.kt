package com.example.contadorprojectipo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.contadorprojectipo.ui.theme.ContadorProjectIPOTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContadorProjectIPOTheme {

                val navController = rememberNavController()
                val viewModel = ViewModelProvider(this).get(CounterChangeViewModel::class.java)
                val count = viewModel.getCounter()

                NavHost(navController = navController, startDestination = CounterScreen) {
                    composable<CounterScreen> {

                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center) {
                            Column {
                                ClickCounter(navController, viewModel, count )
                            }
                        }
                    }
                    composable<DisplayCounterScreen> {
                            backStackEntry ->
                        val counter = backStackEntry.arguments?.getInt("counter") ?: 0

                        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                            Column {
                                DisplayCounter(
                                    counter = counter,
                                    modifier = Modifier.padding(innerPadding)
                                )
                                Button( onClick = { navController.navigate(route = CounterScreen) }) { Text("Counter Screen") }
                            }
                        } }
                }


            }
        }
    }
}

class CounterChangeViewModel : ViewModel() {
    var count: Int by mutableStateOf(0)

    fun increment() {
        count++
    }

    fun decrement() {
        count--
    }

    fun setZero() {
        count = 0
    }

    fun getCounter() : Int {
        return count
    }
}

@Serializable
object CounterScreen

@Serializable
data class DisplayCounterScreen(var counter: Int)

@Composable
fun DisplayCounter(counter: Int, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $counter!",
        modifier = modifier
    )
}

@Composable
fun ClickCounter(navController: NavController, viewModel:  CounterChangeViewModel, count: Int) {

    Column {
        Text(text = "You clicked ${count} times")
        Button( onClick = { viewModel.increment() } ) { Text("Increment") }
        Button( onClick = { viewModel.decrement() } ) { Text("Decrement") }
        Button( onClick = { navController.navigate(DisplayCounterScreen(count)) }) { Text("Display Counter Screen") }
    }
}