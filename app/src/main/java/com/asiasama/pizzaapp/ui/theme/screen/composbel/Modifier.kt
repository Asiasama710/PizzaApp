package com.asiasama.pizzaapp.ui.theme.screen.composbel

import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.asiasama.pizzaapp.ui.theme.Black_37


@Stable
fun Modifier.customShadow(shape: Shape) = then(
    this.shadow(
        elevation = 16.dp,
        shape = shape,
        ambientColor = Black_37,
        spotColor = Black_37
    )
)