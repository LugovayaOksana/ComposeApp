package com.app.composeapp

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class StyleActivity : ComponentActivity() {

    private var timerValue by mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch(Dispatchers.Default){
            while (isActive) {
                timerValue = updateTime()
                delay(500L)
            }
        }
        val fontFamily = FontFamily(
            Font(R.font.lexend_bold, FontWeight.Thin),
            Font(R.font.lexend_light, FontWeight.Light),
            Font(R.font.lexend_regular, FontWeight.Normal),
            Font(R.font.lexend_medium, FontWeight.Medium),
            Font(R.font.lexend_semibold, FontWeight.SemiBold),
            Font(R.font.lexend_bold, FontWeight.Bold),
            Font(R.font.lexend_extrabold, FontWeight.ExtraBold)
        )
        setContent {
            val scope = rememberCoroutineScope()

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF000000))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "Jetpack Compose",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Center,
                        textDecoration = TextDecoration.Underline,
                    )

                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style= SpanStyle(
                                    color = Color.Green,
                                    fontSize = 50.sp
                                )
                            ) {
                                append("J")
                            }
                            append("etpack")
                            withStyle(
                                style= SpanStyle(
                                    color = Color.Green,
                                    fontSize = 50.sp
                                )
                            ) {
                                append("C")
                            }
                            append("ompose")
                        },
                        color = Color.White,
                        fontSize = 30.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Center,
                        textDecoration = TextDecoration.Underline,
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    Spacer(modifier = Modifier.height(30.dp))
                    Canvas(
                        modifier = Modifier.fillMaxSize(),
                        onDraw = {
                            drawIntoCanvas {
                                it.nativeCanvas.drawText(
                                    timerValue,
                                    0f,
                                    8.dp.toPx(),
                                    textPaintStroke
                                )
                                it.nativeCanvas.drawText(
                                    timerValue,
                                    0f,
                                    8.dp.toPx(),
                                    textPaint
                                )
                            }
                        }
                    )
                }

            }
        }
    }
}

val textPaintStroke = Paint().asFrameworkPaint().apply {
    isAntiAlias = true
    style = android.graphics.Paint.Style.STROKE
    textSize = 34f
    color = android.graphics.Color.RED
    strokeWidth = 6f
    strokeMiter= 6f
    strokeJoin = android.graphics.Paint.Join.ROUND
}

val textPaint = Paint().asFrameworkPaint().apply {
    isAntiAlias = true
    style = android.graphics.Paint.Style.FILL
    textSize = 34f
    color = android.graphics.Color.WHITE
}


@SuppressLint("SimpleDateFormat")
fun updateTime():String {
//    val customFont = Typeface.createFromAsset(this.assets, "font/Circe-ExtraBold.ttf")
    val date = Date()
    val fmt = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    return fmt.format(date)
}



