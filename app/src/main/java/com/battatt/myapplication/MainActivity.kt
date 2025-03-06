package com.battatt.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.battatt.myapplication.ui.theme.screen.MainScreen
import com.battatt.myapplication.ui.theme.NomNomBoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NomNomBoxTheme {
                MainScreen()
            }
        }
    }
}
