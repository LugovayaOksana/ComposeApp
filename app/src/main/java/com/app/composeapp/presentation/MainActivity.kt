package com.app.composeapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//Test Column
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val interactionSource = remember { MutableInteractionSource() }
            val isPressed by interactionSource.collectIsPressedAsState()
            val color = if (isPressed) Color.Blue else Color.DarkGray

            Column(
                modifier = Modifier
                    .background(Color.Green)
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth()
                    .padding(top = 50.dp)
                    .border(5.dp, Color.Magenta)
//                    .width(300.dp)
//                    .requiredWidthIn(800.dp),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    "qqqqqq",
                    modifier = Modifier
                        .offset(0.dp, 20.dp)
                )
                Spacer(
                    modifier = Modifier
                        .height(50.dp)
                        .background(Color.Yellow)
                )
                Text(
                    "wwwwwww",
                    modifier = Modifier
                        .border(5.dp, Color.Yellow)
                        .padding(5.dp)
                        .offset(20.dp, 20.dp)
                        .border(10.dp, Color.Black)
                        .padding(10.dp)
                )
                Text("ppppppp")
            }
            Button(
                onClick = { /*TODO*/ },
                interactionSource = interactionSource,
                colors= ButtonDefaults.buttonColors(backgroundColor = color),
                shape = RoundedCornerShape(30),
                border = BorderStroke(1.dp, Color.Red),
                modifier = Modifier
//                    .size(100.dp)
                    .width(100.dp)
                    .height(50.dp)
//                    .border(1.dp, Color.Red, shape = RoundedCornerShape(30))
                ) {
                Text(
                    "Start",
                    modifier = Modifier
                        .background(Color.Cyan)
                        .border(1.dp, Color.Blue)
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Greeting("qqq")
}