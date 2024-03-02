package com.blackpaws.day8mvvmcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.blackpaws.day8mvvmcounter.ui.theme.Day8MVVMCounterTheme

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: CounterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[CounterViewModel::class.java]
        setContent {
            Day8MVVMCounterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterApp(viewModel = viewModel)
                }
            }
        }
    }
}
@Composable
fun CounterApp(viewModel: CounterViewModel){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
            .rotate(viewModel.rotationState.value),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Value = ${viewModel.count.value}",
            color = Color.White)
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.wrapContentSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                viewModel.increment()
            }) {
                Text(text = "Increment")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = {
                viewModel.decrement()
            }) {
                Text(text = "Decrement")
            }
        }
    }
}
