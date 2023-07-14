package com.asiasama.pizzaapp.ui.theme.screen.food_details

import android.util.Log
import androidx.lifecycle.ViewModel
import com.asiasama.pizzaapp.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class FoodDetailsViewModel : ViewModel() {

    private val _state = MutableStateFlow(FoodUiState())
    val state = _state.asStateFlow()


    init {
        getPizzaSize()
        getPizzaType()
        getIngredient()
    }

    private fun getPizzaType() {
        _state.update {
            it.copy(
                pizza = listOf(
                    PizzaUiState(pizzaImage = R.drawable.bread_1),
                    PizzaUiState(pizzaImage = R.drawable.bread_2),
                    PizzaUiState(pizzaImage = R.drawable.bread_3),
                    PizzaUiState(pizzaImage = R.drawable.bread_4),
                    PizzaUiState(pizzaImage = R.drawable.bread_5),
                )
            )
        }
    }

    private fun getIngredient() {
        _state.update {
            it.copy(
                ingredient = listOf(
                    IngredientUiState(id = 0, image = R.drawable.ic_basil),
                    IngredientUiState(id = 1, image = R.drawable.ic_broccoli),
                )
            )
        }
    }

    private fun getPizzaSize() {
        _state.update {
            it.copy(
                pizzaSize = listOf(
                    PizzaSizeUiState(
                        pizzaSize = "S",
                        isSelected = false
                    ),
                    PizzaSizeUiState(
                        pizzaSize = "M",
                        isSelected = true
                    ),
                    PizzaSizeUiState(
                        pizzaSize = "L",
                        isSelected = false
                    )
                )
            )
        }
    }

    fun onClickPizzaSize(selectedPizzaSize: String) {
        _state.update { currentState ->
            val updatedDates = currentState.pizzaSize.map { pizza ->
                if (pizza.pizzaSize == selectedPizzaSize) {
                    pizza.copy(isSelected = !pizza.isSelected)
                } else {
                    pizza.copy(isSelected = false)
                }
            }
            currentState.copy(pizzaSize = updatedDates, selectedPizzaSize = selectedPizzaSize)
        }
    }

    fun onClickIngredient(IngredientIndex: Int,currentIngredient: Int) {
        _state.update {
            it.copy(
                ingredient = it.ingredient.mapIndexed { index, ingredient ->
                    if (index == IngredientIndex) {
                        Log.e("TAG", "onClickIngredient: ${ingredient.isSelectedIngredient}")
                        Log.e(
                            "TAG",
                            "onClickIngredient index : $index , IngredientIndex : $IngredientIndex"
                        )
                        ingredient.copy(isSelectedIngredient = !ingredient.isSelectedIngredient)

                    } else {
                        Log.e(
                            "TAG",
                            "onClickIngredient index : $index , IngredientIndex : $IngredientIndex"
                        )
                        ingredient.copy(isSelectedIngredient = ingredient.isSelectedIngredient)
                    }

                },
                currentPage = currentIngredient,
                pizza = it.pizza.mapIndexed { index, pizza ->
                    if (index == currentIngredient) {
                        pizza.copy(pizzaIngredient = !pizza.pizzaIngredient)
                    } else {
                        pizza.copy(pizzaIngredient = pizza.pizzaIngredient)
                    }
                }
            )

        }
        Log.e("TAG", "pizaa: ${_state.value}")

        Log.e("TAG", "ingredient[IngredientIndex].isSelectedIngredient: ${_state.value.ingredient[IngredientIndex].isSelectedIngredient}")
        Log.e("TAG", "ingredient: ${_state.value.ingredient}")

//        val updatedIngredients = ingredients
//        if (ingredients.isSelectedIngredient) {
//            updatedIngredients.copy(isSelectedIngredient = false)
//        } else {
//            updatedIngredients.copy(isSelectedIngredient = true)
//        }
//        _state.update { foodUiState ->
//            val updatedIngredients = foodUiState.ingredient.map { ingredient ->
//                if (ingredient.id == IngredientIndex) {
//                    ingredient.copy(isSelectedIngredient = !ingredient.isSelectedIngredient)
//
//                } else {
//                    ingredient.copy(isSelectedIngredient = false)
//                }
//            }
//            foodUiState.copy(
//                ingredient = updatedIngredients,
//                currentPage = IngredientIndex,
//            )
//        }
//        _state.value.ingredient.map {
//            if (it.id == selectedIngredient) {
//                _state.update { it.copy(selectedIngredient = true) }
//            } else {
//                _state.update { it.copy(selectedIngredient = true) }
//            }
//        }
    }


}

