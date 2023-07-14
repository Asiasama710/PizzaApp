package com.asiasama.pizzaapp.ui.theme.screen.food_details

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.asiasama.pizzaapp.R
import com.asiasama.pizzaapp.ui.theme.Secondary
import com.asiasama.pizzaapp.ui.theme.White_FF
import com.asiasama.pizzaapp.ui.theme.screen.AppBarWithIcon
import com.asiasama.pizzaapp.ui.theme.screen.Chip
import com.asiasama.pizzaapp.ui.theme.screen.IngredientChip
import com.asiasama.pizzaapp.ui.theme.screen.Pager
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.DelicateCoroutinesApi

@Preview(showSystemUi = true)
@Composable
fun FoodDetailsScreen(
    viewModel: FoodDetailsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    FoodDetailsContent(
        state = state,
        onClickSize = viewModel::onClickPizzaSize,
        onClickIngredient = viewModel::onClickIngredient
    )

}

@OptIn(ExperimentalPagerApi::class, DelicateCoroutinesApi::class, ExperimentalMaterial3Api::class)
@Composable
fun FoodDetailsContent(
    state: FoodUiState,
    onClickSize: (String) -> Unit = {},
    onClickIngredient: (Int,Int) -> Unit ,
) {

    val pagerState = rememberPagerState(
        pageCount = state.pizza.size,
        infiniteLoop = false,
        initialPage = 1,
    )
    Column(
        modifier = Modifier
            .padding(top = 24.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AppBarWithIcon(modifier = Modifier.padding(horizontal = 24.dp))

        Box(
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 68.dp)
        ) {
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.Center)
                    .size(250.dp)
                    .paint(painter = painterResource(id = R.drawable.plate))
            )

            Box {
                Pager(
                    item = state.pizza,
                    pagerState = pagerState,
                    pizzaSize = state.selectedPizzaSize,
                )
            }
        }
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            state.pizzaSize.forEach {
                Chip(
                    modifier = Modifier,
                    text = it.pizzaSize,
                    isSelected = it.isSelected,
                    onChecked = onClickSize
                )
            }
        }

        LazyRow(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            itemsIndexed(items = state.pizza[pagerState.currentPage].ingredient) { position ,item ->
                IngredientChip(
                    modifier = Modifier,
                    state = item,
                    selected = item.isSelectedIngredient,
                    onClick = { onClickIngredient(position,pagerState.currentPage) },
                )
                Log.e("TAG", "FoodDetailsContent: ${state.pizza[pagerState.currentPage]}")
            }
        }
    }


}