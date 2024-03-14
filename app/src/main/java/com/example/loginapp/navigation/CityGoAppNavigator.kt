package com.example.loginapp.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen(){

    object SignUp: Screen()
    object TermsAndConditions: Screen()
    object Login: Screen()
}

object CityGoAppNavigator{

    val currentScreen: MutableState<Screen> = mutableStateOf(Screen.SignUp)

    fun navigateTo(destination: Screen){
        currentScreen.value = destination
    }
}