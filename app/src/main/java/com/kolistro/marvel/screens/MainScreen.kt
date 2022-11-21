package com.kolistro.marvel.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kolistro.marvel.CardHero
import com.kolistro.marvel.Header
import com.kolistro.marvel.Logo
import com.kolistro.marvel.network.characters.Characters
import com.kolistro.marvel.overview.OverviewViewModel
import com.kolistro.marvel.ui.theme.Grey100


/**
 * Главный экран приложения
 * @param listHero список всех героев
 * @param navController компонент навигации
 */
@Composable
fun MainScreen(
    listHero: Characters?,
    navController: NavHostController,
    viewModel: OverviewViewModel,
) {

    Column(horizontalAlignment = Alignment.CenterHorizontally,
           modifier = Modifier
               .background(
                   Brush.linearGradient(
                       colors = listOf(
                           Grey100,
                           Grey100,
                           Grey100,
                       )
                   )
               )
               .fillMaxSize()
    )
    {
        Logo()
        Header()
        LazyRow(modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 40.dp),
            ){
                if (listHero != null)
                {
                    itemsIndexed(
                        listHero.data.results

                    ){_, item ->
                        CardHero(navController, item)
                        viewModel._id.value= item.id
                     }
                }
            }
        }
    }

