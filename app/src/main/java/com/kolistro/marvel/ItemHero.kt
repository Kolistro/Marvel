package com.kolistro.marvel

import androidx.compose.ui.graphics.Color

data class ItemHero(
    val link: String,
    val imageId: Int,
    val name: String,
    val color: Color,
    val description: String
)