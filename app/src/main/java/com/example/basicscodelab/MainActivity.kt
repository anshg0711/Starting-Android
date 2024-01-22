package com.example.basicscodelab

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon

import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var checkClicked by rememberSaveable { mutableStateOf(true) }
            BasicsCodelabTheme {
                if (checkClicked) {
                    OnBoardingActivity(onContinueClicked = { checkClicked = false })
                } else {
                    MyApp(modifier = Modifier.fillMaxSize(), color = Color.Green)
                }

            }
        }


    }

    @Composable

    fun MyApp(modifier: Modifier, color: Color) {
//        var flag by rememberSaveable { mutableStateOf(0) }
        Surface(Modifier.fillMaxSize(), color = color)
        {
            LazyColumn(Modifier.padding(5.dp)) {
                items(10) { index ->
                    BoxInside(name = "\n$index", index%7)
//                            flag= Random.nextInt(1, 10001)
//                    flag++
//                    flag %= 7
                }
            }
        }
    }


    @SuppressLint("SuspiciousIndentation")
    @Composable
    fun BoxInside(name: String, flag: Int) {
        val numbers: Array<Color> = arrayOf(
            Color.Gray,
            Color.Cyan,
            Color.LightGray,
            Color.Red,
            Color.Yellow,
            Color.Blue,
            Color.Unspecified
        )
        var expanded by rememberSaveable { mutableStateOf(1) }
        var color = numbers[flag]
        println("$flag check me")
        Surface(
            Modifier
                .padding(5.dp)
                .fillMaxWidth(), color = color
        ) {
            Row(
                Modifier
                    .padding(19.dp)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
//                val paddingAnimation =15.dp
                Column() {
                    Text(
                        text = "Hello",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineLarge
                    )
                    if (expanded == 0)
                        Text(
                            text = name,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.headlineMedium
                        )
                }
                IconButton(

                    onClick = {
                        expanded = expanded xor 1
                    }
                ) {
                    Icon(
                        imageVector = if (expanded == 1) Icons.Filled.KeyboardArrowDown else Icons.Filled.KeyboardArrowUp,
                        contentDescription = "just a dropdown"
                    )
                    Text(
                        "^", style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
            }
        }
    }

    @Preview(
        showBackground = true,
        widthDp = 320,
        name = "GreetingPreviewDark"
    )
    @Composable
    fun Myap() {
        BasicsCodelabTheme {
            MyApp(modifier = Modifier.fillMaxSize(), color = Color.Green)
        }
    }
}


