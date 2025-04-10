package com.example.loginapp.Components

import android.util.Log
import android.widget.CheckBox
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginapp.R
import com.example.loginapp.R.drawable.person_24px
import com.example.loginapp.ui.theme.TravelHue
import com.example.loginapp.ui.theme.TravelBG
import com.example.loginapp.ui.theme.TravelRed
import com.example.loginapp.ui.theme.componentShapes
import com.example.loginapp.ui.theme.spacing
import androidx.compose.material3.Text as Text1

@Composable
fun SimpleTextComponent(value: String) {
    Text1(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 30.dp),
        style = androidx.compose.ui.text.TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.Serif
        ),
        color = colorResource(id = R.color.black),
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeaderTextComponent(value: String) {
    Text1(
        text = value,
        modifier = Modifier
            .fillMaxWidth(),
        style = androidx.compose.ui.text.TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.Serif
        ),
        color = colorResource(id = R.color.TravelRed),
        textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(labelValue: String, painterResource: Painter) {
    val textValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(componentShapes.small),
        label = { Text1(text = labelValue) },
        value = textValue.value,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = TravelHue,
            focusedLabelColor = TravelHue,
            cursorColor = TravelHue,
            containerColor = TravelBG
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordFieldComponent(labelValue: String, painterResource: Painter) {
    val localFocusManager = LocalFocusManager.current

    val password = remember {
        mutableStateOf("")
    }

    val passwordVisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(componentShapes.small),
        label = { Text1(text = labelValue) },
        value = password.value,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = TravelHue,
            focusedLabelColor = TravelHue,
            cursorColor = TravelHue,
            containerColor = TravelBG
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        singleLine = true,
        maxLines = 1,
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        },
        onValueChange = {
            password.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        },
        trailingIcon = {

            val iconImage = if (passwordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            val description = if (passwordVisible.value) {
                stringResource(id = R.string.hide_password)
            } else {
                stringResource(id = R.string.show_password)
            }

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }
        },

        visualTransformation = if (passwordVisible.value) VisualTransformation.None
        else PasswordVisualTransformation()
    )
}

@Composable
fun CheckBoxComponent(value: String, onTextSelected: (String) -> Unit) {


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(64.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        val checkedState = remember {
            mutableStateOf(false)
        }

        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = !checkedState.value })

        ClickableTextComponent(value = value, onTextSelected)
    }
}

@Composable
fun ClickableTextComponent(value: String, onTextSelected: (String) -> Unit) {
    val initialText = "By continuing you accept our "
    val privacyPolicyText = "Privacy Policy"
    val andText = " and "
    val termsAndConditions = "Terms of use."

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(Color.Blue)) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(Color.Blue)) {
            pushStringAnnotation(tag = termsAndConditions, annotation = termsAndConditions)
            append(termsAndConditions)
        }
    }

    ClickableText(text = annotatedString, onClick = { offset ->

        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
                Log.d("ClickableTextComponent", "{${span.item}}")

                if ((span.item == termsAndConditions) || (span.item == privacyPolicyText)) {
                    onTextSelected(span.item)
                }
            }
    })
}

@Composable
fun ButtonComponent(value: String) {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(TravelRed, TravelHue)),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun DividerComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Divider(
            Modifier
                .fillMaxWidth()
                .weight(1f),
            color = Color.Gray,
            thickness = 1.5.dp
        )

        Text(
            modifier = Modifier.padding(10.dp),
            text = stringResource(id = R.string.Or),
            fontSize = 14.sp,
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold
        )

        Divider(
            Modifier
                .fillMaxWidth()
                .weight(1f),
            color = Color.Gray,
            thickness = 1.5.dp
        )

    }
}

@Composable
fun ClickableLoginTextComponent(tryingToLogin: Boolean = true, onTextSelected: (String) -> Unit) {
    val initialText =
        if (tryingToLogin) "Already have an Account? " else "Don't have an account yet?"
    val loginText = if (tryingToLogin) "Login" else " Register"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(Color.Blue)) {
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
    }

    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 30.dp),
        style = androidx.compose.ui.text.TextStyle(
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center
        ),
        text = annotatedString, onClick = { offset ->

            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    Log.d("ClickableTextComponent", "{${span.item}}")

                    if (span.item == loginText) {
                        onTextSelected(span.item)
                    }
                }
        })
}

@Composable
fun UnderlineTextComponent(value: String) {
    Text1(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 30.dp),
        style = androidx.compose.ui.text.TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.Serif
        ),
        color = Color.Gray,
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}