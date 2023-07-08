package com.amk.drugreminder

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amk.drugreminder.ui.theme.DrugReminderTheme
import com.amk.drugreminder.ui.theme.titleLarge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrugReminderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        floatingActionButton = { FAB() }
    ) {
        TopBar()
    }

}


@Composable
fun TopBar() {
    Surface(modifier = Modifier.fillMaxWidth()) {

        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.img_bg),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Text(
            text = "،روزت بخیر\n" +
                    "امیرمحمد",
            textAlign = TextAlign.Right,
            modifier = Modifier
                .wrapContentSize(align = Alignment.TopEnd)
                .padding(top = 30.dp, end = 24.dp),
            style = titleLarge,
            fontSize = 30.sp,
            color = Color.White,
            lineHeight = 36.sp
        )
    }
}

@Composable
fun FAB() {
    ExtendedFloatingActionButton(
        text = {
            Text(
                text = "افزودن دارو",
                style = TextStyle(fontFamily = FontFamily(Font(resId = R.font.nahid)))
            )
        },
        icon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
        onClick = { },
        containerColor = MaterialTheme.colorScheme.primary
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DrugReminderTheme {
        MainScreen()
    }
}