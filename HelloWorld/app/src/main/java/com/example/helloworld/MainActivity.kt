package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val size = 32

        setContent {
            Greeting(name="Joe")
        }
    }
}

@Composable
fun Greeting(name: String) {
    val colors = listOf(Color.Red, Color.Yellow, Color.Green, Color.Blue)
    val currentColor = remember { mutableIntStateOf(0) }
    val textSize = remember { mutableIntStateOf(32) }

    val incrementColor = {
        if (currentColor.intValue + 1 >= colors.count()) {
            currentColor.intValue = 0
        } else {
            currentColor.intValue++
        }
    }
    Column(modifier = Modifier.background(Color.Black).fillMaxSize().padding(32.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(
            text = "Hello $name",
            fontSize = textSize.intValue.sp,
            color = colors[currentColor.intValue],
        )

        Button(onClick = { incrementColor() } ) {
            Text("Change color")
        }

        Slider(
            value = (textSize.intValue - 32).toFloat(),
            onValueChange = { newSize -> textSize.intValue = newSize.toInt() + 32},
            valueRange = 0f..32f
        )
    }
}