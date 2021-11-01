package com.app.composeapp.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.composeapp.calculator.Calculator

class StartActivity : ComponentActivity() {

    val activities = listOf(
        AnimatedCircularProgressBar::class.java,
        ButtonStyles::class.java,
        Calculator::class.java,
        ConstraintLayout::class.java,
        DraggableMusicKnob::class.java,
        ImgActivity::class.java,
        ListActivity::class.java,
        MainActivity::class.java,
        SideEffectsAndEffectsHandle::class.java,
        SimpleAnimations::class.java,
        StateActivity::class.java,
        StyleActivity::class.java,
        TextBtnSnack::class.java
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(Modifier.padding(5.dp)) {
                Column() {
                    activities.forEach {
                        Button(onClick = {
                            startActivity(Intent(this@StartActivity, it).apply {
                                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                            })
                        }) {
                            Text(text = it.canonicalName!!)
                        }
                    }
                 /*   Button(onClick = { goTo<Calculator>() }) {

                    }
                    Button(onClick = { goTo<ImgActivity>()  }) {

                    }*/
                }
            }
        }
    }

    private inline fun <reified T> goTo() {
        startActivity(Intent(this, T::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        })
    }

}

