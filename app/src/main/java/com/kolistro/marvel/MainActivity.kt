package com.kolistro.marvel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kolistro.marvel.ui.theme.Grey100



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Screen()
        }
    }
}

@Composable
fun Screen(){
    var color = remember {
        mutableStateOf(Grey100)
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally,
           modifier = Modifier
            .background(Brush.linearGradient(colors = listOf(
                Grey100,
                Grey100,
                color.value
            )))
            .fillMaxSize()
    )
    {
        Image(painter = painterResource(id = R.drawable.marvel),
            contentDescription = "logo",
            modifier = Modifier
                .padding(1.dp)
                .size(110.dp)
        )
        Text(text = "Choose your hero",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        LazyRow(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(35.dp),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 40.dp)

        ){
            itemsIndexed(
                listOf(
                    ItemHero(R.drawable.daredevil, "Daredevil", Color.Yellow),
                    ItemHero(R.drawable.doctor_strange, "Doctor_Strange", Color.Green),
                    ItemHero(R.drawable.iron_man, "Iron Man", Color.Blue),
                    ItemHero(R.drawable.spider_man, "Daredevil", Color.Red),
                    ItemHero(R.drawable.groot, "Groot", Color.Blue),
                )
            ){_, item ->
                CardHero(item = item)
                color.value = item.color
            }
        }

    }

}

