package com.asiasama.pizzaapp.ui.theme.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asiasama.pizzaapp.ui.theme.Primary
import com.asiasama.pizzaapp.ui.theme.RoundedShape
import com.asiasama.pizzaapp.ui.theme.Secondary
import com.asiasama.pizzaapp.ui.theme.White_FF
import com.asiasama.pizzaapp.ui.theme.screen.food_details.IngredientUiState

@Preview
@Composable
fun Chip(
    modifier: Modifier = Modifier,
    text: String = "M",
    isSelected: Boolean = false,
    onChecked: (String) -> Unit = {},
) {

    Box(
        modifier = modifier
            .background(
                color = if (isSelected) Primary else White_FF,
                shape = RoundedShape.extraSmall
            )
            .border(
                width = if (isSelected) 2.dp else 1.dp,
                color = if (isSelected) Color.Transparent else Secondary,
                shape = RoundedShape.extraSmall
            )
            .padding(12.dp)
            .clickable {
                onChecked(text)
            }
            .wrapContentSize()
    ) {
        Text(
            text = text, style = MaterialTheme.typography.headlineSmall,
            color = if (isSelected) White_FF else Primary
        )
    }
}

@Composable
fun IngredientChip(
    modifier: Modifier = Modifier,
    state: IngredientUiState,
    selected: Boolean,
    onClick: () -> Unit,
) {
//    var selected by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .background(
                color = if (selected) Secondary else White_FF,
                shape = RoundedShape.extraSmall
            )
            .border(
                width = if (selected) 0.dp else 1.dp,
                color = if (selected) Color.Transparent else Secondary,
                shape = RoundedShape.extraSmall
            )
            .padding(12.dp)
            .clickable {
                onClick()
              //  selected = !selected
                Log.e("TAG", "IngredientChip: ${state.id}")
            }
            .size(60.dp)
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.Center),
            painter = painterResource(id = state.image), contentDescription = null
        )
    }
}
