package com.example.unitconverter2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.unitconverter2.ui.theme.UnitConverter2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverter2Theme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation(){
    var showSplash by remember { mutableStateOf(true) }

    if(showSplash){
        SplashScreen (
            onNavigateToMain = {showSplash = false}
        )
    }else{
        MainScreen()
    }
}