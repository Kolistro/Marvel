package com.kolistro.marvel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.kolistro.marvel.navigation.ScreenNavHost
import com.kolistro.marvel.ui.theme.Grey100


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val listHero = listOf(
                ItemHero("026ddm_ons_crd_02_1.jpg",R.drawable.daredevil, "Daredevil", Color.Yellow, "I'm Daredevil"),
                ItemHero("009drs_ons_crd_03.jpg",R.drawable.doctor_strange, "Doctor_Strange", Color.Green, "I'm Doctor_Strange"),
                ItemHero("002irm_ons_crd_03.jpg",R.drawable.iron_man, "Iron Man", Color.Cyan, "I'm Iron Man"),
                ItemHero("spidey03_ons_crd_01.jpg",R.drawable.spider_man, "Spider Man", Color.Red, "I'm Daredevil"),
                ItemHero("024grt_ons_crd_01-1.jpg",R.drawable.groot, "Groot", Color.Blue, "I'm Groot"),
            )
            val hero = remember {
                mutableStateOf(ItemHero("024grt_ons_crd_01-1.jpg",R.drawable.groot, "Hero", Grey100, ""))
            }
            ScreenNavHost(listHero, hero)
        }
    }
}


