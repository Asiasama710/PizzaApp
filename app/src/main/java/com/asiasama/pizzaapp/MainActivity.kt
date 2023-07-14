package com.asiasama.pizzaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.asiasama.pizzaapp.ui.theme.PizzaAppTheme
import com.asiasama.pizzaapp.ui.theme.screen.food_details.FoodDetailsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaAppTheme {
             FoodDetailsScreen()
            }
        }
    }
}

