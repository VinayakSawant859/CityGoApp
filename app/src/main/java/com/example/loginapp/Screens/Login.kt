package com.example.loginapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.loginapp.Components.ButtonComponent
import com.example.loginapp.Components.ClickableLoginTextComponent
import com.example.loginapp.Components.DividerComponent
import com.example.loginapp.Components.HeaderTextComponent
import com.example.loginapp.Components.PasswordFieldComponent
import com.example.loginapp.Components.SimpleTextComponent
import com.example.loginapp.Components.TextFieldComponent
import com.example.loginapp.Components.UnderlineTextComponent
import com.example.loginapp.R
import com.example.loginapp.navigation.CityGoAppNavigator
import com.example.loginapp.navigation.Screen
import com.example.loginapp.navigation.SystemBackButtonHandler

@Composable
fun Login() {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp, start = 15.dp, end = 15.dp)
            .background(Color.White)

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            SimpleTextComponent(value = stringResource(id = R.string.Hello))
            HeaderTextComponent(value = stringResource(id = R.string.welcome_back))
            Spacer(modifier = Modifier.height(30.dp))

            TextFieldComponent(
                labelValue = stringResource(id = R.string.email),
                painterResource = painterResource(id = R.drawable.mail_24px)
            )

            PasswordFieldComponent(
                labelValue = stringResource(id = R.string.password),
                painterResource = painterResource(id = R.drawable.lock_24px)
            )

            Spacer(modifier = Modifier.height(15.dp))
            UnderlineTextComponent(value = stringResource(id = R.string.forgot_password))

            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(value = stringResource(id = R.string.login))

            Spacer(modifier = Modifier.height(40.dp))
            DividerComponent()

            Spacer(modifier = Modifier.height(260.dp))
            ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                CityGoAppNavigator.navigateTo(Screen.SignUp)
            })
        }
    }

    SystemBackButtonHandler {
        CityGoAppNavigator.navigateTo(Screen.SignUp)
    }
}