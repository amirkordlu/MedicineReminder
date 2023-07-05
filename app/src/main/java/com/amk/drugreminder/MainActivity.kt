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
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.amk.drugreminder.ui.theme.DrugReminderTheme

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
    Image(
        modifier = Modifier.fillMaxWidth(),
        painter = painterResource(id = R.drawable.img_bg_top),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun FAB() {
    ExtendedFloatingActionButton(
        text = { Text(text = "Add Medicine") },
        icon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
        onClick = {  },
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