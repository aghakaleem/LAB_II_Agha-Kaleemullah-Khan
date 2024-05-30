package com.example.lab_02

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Button_State_Management(){
    val buttonText = remember{
        mutableStateOf("Click me")
    }

    val buttonColor = remember {
        mutableStateOf(Color.Red)
    }

    val buttonState = remember {
        mutableStateOf(false)
    }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(
            onClick = {
                buttonText.value = if(buttonState.value) "Click me" else "Clicked"
                buttonColor.value = if(buttonState.value) Color.Red else Color.Green
                buttonState.value = !buttonState.value
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = buttonColor.value
            ),
            shape = RoundedCornerShape(5.dp)
        ) {
            Text(text = buttonText.value, fontSize = 20.sp)
        }
    }
}