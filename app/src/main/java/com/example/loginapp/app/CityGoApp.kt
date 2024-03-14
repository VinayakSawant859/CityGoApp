package com.example.loginapp.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.loginapp.Screens.Login
import com.example.loginapp.Screens.SignUp
import com.example.loginapp.Screens.TermsAndConditionsScreen
import com.example.loginapp.navigation.CityGoAppNavigator
import com.example.loginapp.navigation.Screen

@Composable
fun CityGoApp(){
    Surface(modifier = Modifier.fillMaxSize(),
                        color = Color.White
                    ) {

        Crossfade(targetState = CityGoAppNavigator.currentScreen) { currentState ->
            when (currentState.value) {

                is Screen.SignUp ->{ SignUp() }

                is Screen.TermsAndConditions ->{ TermsAndConditionsScreen() }

                is Screen.Login ->{ Login() }
            }
        }
    }
}