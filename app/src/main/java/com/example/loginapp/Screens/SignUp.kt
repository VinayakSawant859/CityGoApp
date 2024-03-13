package com.example.loginapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.loginapp.Components.ButtonComponent
import com.example.loginapp.Components.CheckBoxComponent
import com.example.loginapp.Components.HeaderTextComponent
import com.example.loginapp.Components.PasswordFieldComponent
import com.example.loginapp.Components.SimpleTextComponent
import com.example.loginapp.Components.TextFieldComponent
import com.example.loginapp.R
import com.example.loginapp.navigation.CityGoAppNavigator
import com.example.loginapp.navigation.Screen

@Composable
fun SignUp(){

    Surface(color = Color.White,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp, start = 15.dp, end = 15.dp)
                .background(Color.White)

        ) {
            Column(modifier = Modifier.fillMaxSize()){
                SimpleTextComponent(value = stringResource(id = R.string.Hello))
                HeaderTextComponent(value = stringResource(id = R.string.create_account))

                Spacer(modifier = Modifier.height(20.dp))
                TextFieldComponent(labelValue = stringResource(id = R.string.first_name),
                    painterResource(id = R.drawable.person_24px)
                )
                TextFieldComponent(
                    labelValue = stringResource(id = R.string.last_name),
                    painterResource = painterResource(id = R.drawable.person_24px)
                )
                TextFieldComponent(
                    labelValue = stringResource(id = R.string.email),
                    painterResource = painterResource(id = R.drawable.mail_24px)
                )
                PasswordFieldComponent(
                    labelValue = stringResource(id = R.string.password),
                    painterResource = painterResource(id = R.drawable.lock_24px)
                )

                CheckBoxComponent(value = stringResource(id = R.string.terms_and_conditions),
                    onTextSelected = {
                        CityGoAppNavigator.navigateTo(Screen.TermsAndConditions)
                    })
                
                Spacer(modifier = Modifier.height(30.dp))
                ButtonComponent(value = stringResource(id = R.string.register))
            }

    }
}