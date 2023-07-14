package com.asiasama.pizzaapp.ui.theme.screen.food_details

/**
 * Created by Asia sama on 7/10/2023.
 * sehunexo710@gmail.com
 */
data class FoodUiState(
    val pizza: List<PizzaUiState> = emptyList(),
    val pizzaSize: List<PizzaSizeUiState> = emptyList(),
    val selectedPizzaSize: String = "M",
    val currentPage: Int = 0,
)

data class PizzaSizeUiState(
    val pizzaSize: String = "M",
    val isSelected: Boolean = true,
)

data class IngredientUiState(
    val id: Int = 0,
    val image: Int = 0,
    val imageIcon: Int = 0,
    var isSelectedIngredient: Boolean = false,
 )

data class PizzaUiState(
    val pizzaImage: Int = 0,
    val pizzaIngredient:Boolean = false,
    val ingredient: List<IngredientUiState> = emptyList(),
)

