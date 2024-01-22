package com.example.basicscodelab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.sp


@Composable
fun OnBoardingActivity(onContinueClicked: () -> Unit){

    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Welcome to the hitting club", color = Color.Magenta, fontWeight = FontWeight.SemiBold, fontSize =28.sp)
        Text(text = "")

        ElevatedButton(onClick = { onContinueClicked() }, colors = ButtonDefaults.buttonColors(
            contentColor = Color.Cyan
        )) {
            Text(text = "Harder", fontWeight = FontWeight.ExtraBold, fontStyle = FontStyle.Italic)

        }
    }
}





