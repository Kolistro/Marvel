package com.kolistro.marvel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Отвечает за отрисовку списка героев
 * @param color состояние отвечающее за цвет героя
 */
@Composable
fun ListHero(color: MutableState<Color>) {
    LazyRow(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(35.dp),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 40.dp),

        ){
        itemsIndexed(
            listOf(
                ItemHero(R.drawable.daredevil, "Daredevil", Color.Yellow),
                ItemHero(R.drawable.doctor_strange, "Doctor_Strange", Color.Green),
                ItemHero(R.drawable.iron_man, "Iron Man", Color.Cyan),
                ItemHero(R.drawable.spider_man, "Daredevil", Color.Red),
                ItemHero(R.drawable.groot, "Groot", Color.Blue),
            )
        ){_, item ->
            CardHero(item = item)
            color.value = item.color
        }
    }
}