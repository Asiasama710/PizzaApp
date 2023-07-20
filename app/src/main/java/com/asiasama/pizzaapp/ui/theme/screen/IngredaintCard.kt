package com.asiasama.pizzaapp.ui.theme.screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asiasama.pizzaapp.ui.theme.Black_60
import com.asiasama.pizzaapp.ui.theme.ChipColor
import com.asiasama.pizzaapp.ui.theme.Primary
import com.asiasama.pizzaapp.ui.theme.RoundedShape
import com.asiasama.pizzaapp.ui.theme.Secondary
import com.asiasama.pizzaapp.ui.theme.Typography
import com.asiasama.pizzaapp.ui.theme.White_FF
import com.asiasama.pizzaapp.ui.theme.screen.food_details.IngredientUiState

@Preview(showBackground = true)
@Composable
fun Chip(
    modifier: Modifier = Modifier,
    text: String = "M",
    isSelected: Boolean = false,
    onChecked: (String) -> Unit = {},
) {
    val scale by animateFloatAsState(if (isSelected) 1.2f else 1f)
    val elevation by animateDpAsState(if (isSelected) 16.dp else 0.dp)

    IconButton(
        modifier = modifier
            .size(46.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            ),
        onClick = { onChecked(text) },
    ) {
        Text(
            text = text, style = Typography.titleMedium,
            color = Primary,
        )
    }
}


@Composable
fun IngredientChip(
    modifier: Modifier = Modifier,
    state: IngredientUiState,
    isSelected: Boolean,
    onClick: () -> Unit,
) {

    val scale by animateFloatAsState(if (isSelected) 1.2f else 1f)

    IconButton(
        onClick = { onClick() },
        modifier = modifier
            .background(
                color = if (isSelected) ChipColor else White_FF,
                shape = CircleShape
            )
            .background(
                color = if (isSelected) ChipColor else White_FF,
                shape = CircleShape
            )
            .size(60.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            ),

        ) {
        Image(
            painter = painterResource(id = state.imageIcon),
            contentDescription = null,
            modifier = Modifier
                .padding(8.dp)
                .size(54.dp, 54.dp)
                .clip(CircleShape)
                .background(
                    color = if (isSelected) ChipColor else White_FF,
                    shape = CircleShape
                ),
        )
    }
}