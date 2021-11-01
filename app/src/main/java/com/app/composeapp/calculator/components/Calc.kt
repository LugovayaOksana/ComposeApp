package com.app.composeapp.calculator.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import kotlinx.coroutines.flow.mapLatest

@Composable
fun CalculatorScreen() {
    val state = remember {
        CalculatorState()
    }
    Calculator(state = state)
}

class CalculatorState {
    var v1 by mutableStateOf("0")
    var v2 by mutableStateOf("0")

//    val result get() = sum(v1, v2)

    val result = snapshotFlow { v1 to v2 }.mapLatest {
        sum(it.first, it.second) //sum is a suspend method here
    }
}

@Composable
fun Calculator(state: CalculatorState) {
    Column {
        TextField(value = state.v1, onValueChange = { state.v1 = it })
        TextField(value = state.v2, onValueChange = { state.v2 = it })

//        Text(text = state.result)
        Text(text = state.result.collectAsState(initial = "").value)
    }
}

fun sum(v1: String, v2: String) = try {
    (v1.toInt() + v2.toInt()).toString()
} catch (e: NumberFormatException) {
    "Parsing error :("
}
