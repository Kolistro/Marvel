package com.kolistro.marvel

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

/**
 * Отвечает за логотип страницы
 */
@Composable
fun Logo() {
    Image(painter = painterResource(id = R.drawable.marvel),
        contentDescription = "logo",
        modifier = Modifier
            .padding(1.dp)
            .size(110.dp)
    )
}