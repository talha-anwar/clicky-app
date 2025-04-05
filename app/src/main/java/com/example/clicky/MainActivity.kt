package com.example.clicky

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clicky.ui.theme.ClickyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClickyTheme {
                ClickCounter()
            }
        }
    }
}

@Composable
fun ClickCounter() {
    var count by remember { mutableIntStateOf(0) }

    // UI layout
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$count",
            fontSize = 48.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(onClick = { count++ }) {
                Text(text = "Click Me!")
            }

            Button(onClick = { count = 0 }) {
                Text(text = "Reset")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ClickCounterPreview() {
    ClickyTheme {
        ClickCounter()
    }
}
