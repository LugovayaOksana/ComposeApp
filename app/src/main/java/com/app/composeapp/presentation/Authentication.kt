package com.app.composeapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.app.composeapp.R

class Authentication : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(

                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                ) {
                    IconButton(
                        onClick = {
//                            text.value = "Upload clicked."
                                  },
                    ){
                        Icon(
                            painter = painterResource(id = R.drawable.fingerprint_scan),
                            contentDescription = "finger scan",
//                            tint = Color.Red
                        )
                    }

                }

            }
        }
    }
}