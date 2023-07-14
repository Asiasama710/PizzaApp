package com.asiasama.pizzaapp.ui.theme.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.asiasama.pizzaapp.ui.theme.screen.food_details.IngredientUiState
import com.asiasama.pizzaapp.ui.theme.screen.food_details.PizzaUiState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.DelicateCoroutinesApi


@OptIn(ExperimentalAnimationApi::class)
@DelicateCoroutinesApi
@ExperimentalPagerApi
@Composable
fun Pager(
    modifier: Modifier = Modifier,
    item: List<PizzaUiState> = emptyList(),
    pagerState: PagerState,
    currentPage: Int = 0,
    pizzaSize: String = "M",
    ingredientUiState: Boolean = false,
    ingredient: List<IngredientUiState>,

    ) {
    val ingredientStateList = remember {
        mutableStateListOf<Boolean>().apply {
            // تعبئة قائمة ingredientStateList بقيم افتراضية لكل صفحة
            addAll(List(item.size) { false })
        }
    }

// تعبئة قائمة ingredientStateList بقيم افتراضية

    HorizontalPager(
        state = pagerState,
        modifier = modifier
            .fillMaxWidth()
            .height(320.dp)
            .padding(top = 12.dp),
    ) { page ->

        val pizzaSize = if (pizzaSize == "S") 200.dp else if (pizzaSize == "M") 210.dp else 250.dp

        val imageSize by animateDpAsState(
            targetValue = pizzaSize,
            animationSpec = tween(100),
        )


        Box(modifier = Modifier) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    modifier = Modifier
                        .size(imageSize)
                        .align(Alignment.Center),
                    painter = painterResource(id = item[page].pizzaImage), contentDescription = null
                )
            }

            Box(modifier = Modifier.fillMaxWidth()) {
                if (currentPage == page) {
                    ingredient.forEachIndexed { index, ingredientUiState ->
                        AnimatedVisibility(
                            visible = item[page].pizzaIngredient,
                            enter = scaleIn() + expandVertically(expandFrom = Alignment.CenterVertically),
                            exit = fadeOut(animationSpec = tween(10))
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(imageSize)
                                    .align(Alignment.Center),
                                painter = painterResource(id = ingredientUiState.image),
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }
    }

}

//            Box(modifier = Modifier.fillMaxWidth()) {
//
//                ingredient.forEachIndexed { index, ingredientUiState ->
//                    if (currentPage == page) {
//                        AnimatedVisibility(
//                            visible = ingredientUiState.isSelectedIngredient,
//                            enter = scaleIn() + expandVertically(expandFrom = Alignment.CenterVertically),
//                            exit = fadeOut(animationSpec = tween(10))
//                        ) {
//                            Image(
//                                modifier = Modifier
//                                    .size(imageSize)
//                                    .align(Alignment.Center),
//                                painter = painterResource(id = ingredientUiState.image),
//                                contentDescription = null
//                            )
//                        }
//                    }
//                }
//            }
//
//else {
//    LaunchedEffect(key1 = page) {
//        if (currentPage != page) {
//            ingredient.forEachIndexed { index, ingredientUiState ->
//                ingredientUiState.isSelectedIngredient = false
//            }
//        }else{
//            ingredient.forEachIndexed { index, ingredientUiState ->
//                ingredientUiState.isSelectedIngredient = true
//            }
//        }
//    }
//}