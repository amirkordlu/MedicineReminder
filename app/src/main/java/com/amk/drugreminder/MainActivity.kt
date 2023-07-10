package com.amk.drugreminder

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amk.drugreminder.ui.theme.*

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
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = { FAB() },
        floatingActionButtonPosition = FabPosition.Center
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            TopBar()

            Text(
                text = "داروهای روزانه شما",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 24.dp, top = 22.dp),
                textAlign = TextAlign.End,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 14.sp,
                    fontFamily = FontFamily(Font(R.font.nahid)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF486581),
                    letterSpacing = 0.52.sp,
                )
            )

            Medicine()
        }
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
                .padding(top = 30.dp, end = 28.dp),
            style = titleLarge,
            fontSize = 30.sp,
            color = Color.White,
            lineHeight = 36.sp
        )

        Cards()
    }
}

@Composable
fun Cards() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 34.dp, end = 34.dp, top = 170.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Surface(
            modifier = Modifier
                .size(150.dp, 140.dp),
            color = GreenLight,
            shape = RoundedCornerShape(22.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_circle),
                contentDescription = null,
                alignment = Alignment.TopEnd,
                modifier = Modifier.size(4.dp)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.padding(top = 18.dp)
            ) {

                Text(
                    text = "ضربان قلب",
                    style = titleLarge,
                    fontSize = 14.sp,
                    color = BlueDark,
                    lineHeight = 36.sp
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_heartbeat),
                    contentDescription = null
                )

            }

        }

        Surface(
            modifier = Modifier
                .size(150.dp, 140.dp),
            color = YellowLight,
            shape = RoundedCornerShape(22.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_circle),
                contentDescription = null,
                alignment = Alignment.TopEnd,
                modifier = Modifier.size(4.dp)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .size(40.dp)
                    .padding(top = 18.dp, start = 10.dp, end = 10.dp)
            ) {

                Text(
                    text = "فشار خون",
                    style = titleLarge,
                    fontSize = 14.sp,
                    color = BlueDark,
                    lineHeight = 36.sp
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_blood),
                    contentDescription = null
                )

            }

        }
    }
}

@Composable
fun Medicine() {
    LazyVerticalGrid(
        contentPadding = PaddingValues(start = 8.dp, end = 8.dp, bottom = 16.dp),
        modifier = Modifier.padding(top = 16.dp),
        columns = GridCells.Fixed(2),
        content = {
            items(3) {
                MedicineItem()
            }
        }
    )
}

@Composable
fun MedicineItem() {
    Surface(
        modifier = Modifier
            .size(203.dp, 135.dp)
            .padding(8.dp),
        color = Cream,
        shape = RoundedCornerShape(14.dp)
    ) {
        Image(
            alignment = Alignment.TopEnd,
            painter = painterResource(id = R.drawable.img_medicine_bubble),
            contentDescription = null
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Top
        ) {
            Text(
                text = "8 صبح",
                style = TextStyle(
                    fontSize = 15.sp,
                    lineHeight = 16.5.sp,
                    fontFamily = FontFamily(Font(R.font.nahid)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF486581),
                    letterSpacing = 0.6.sp,
                )
            )

            Image(
                painter = painterResource(id = R.drawable.ic_capsule),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_checkbox_active),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )

            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "متفورمین",
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 22.sp,
                        fontFamily = FontFamily(Font(R.font.nahid)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF102A43),
                        letterSpacing = 0.8.sp,
                    )
                )

                Text(
                    text = "1 عدد",
                    style = TextStyle(
                        fontSize = 15.sp,
                        lineHeight = 15.sp,
                        fontFamily = FontFamily(Font(R.font.nahid)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF486581),
                        letterSpacing = 0.6.sp,
                    )
                )
            }

        }

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