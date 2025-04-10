package com.example.loginapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.loginapp.Components.HeaderTextComponent
import com.example.loginapp.R
import com.example.loginapp.navigation.CityGoAppNavigator
import com.example.loginapp.navigation.Screen
import com.example.loginapp.navigation.SystemBackButtonHandler

@Composable
fun TermsAndConditionsScreen(){
    Surface( modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(16.dp)){
        
        HeaderTextComponent(value = stringResource(id = R.string.terms_of_use))
    }

    SystemBackButtonHandler {
        CityGoAppNavigator.navigateTo(Screen.SignUp)
    }
}