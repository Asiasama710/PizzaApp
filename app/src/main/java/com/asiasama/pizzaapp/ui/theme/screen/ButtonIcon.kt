package com.asiasama.pizzaapp.ui.theme.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asiasama.pizzaapp.ui.theme.Black_60
import com.asiasama.pizzaapp.ui.theme.RoundedShape
import com.asiasama.pizzaapp.ui.theme.Secondary
import com.asiasama.pizzaapp.ui.theme.White_FA
import com.asiasama.pizzaapp.ui.theme.White_FF


@Composable
fun ButtonIcon(modifier: Modifier = Modifier, onBack: () -> Unit = {}, painter: Painter) {
    IconButton(
        onClick = onBack,
        modifier = modifier.size(32.dp)
            .background(shape = RoundedShape.medium, color = White_FF)
            .border(2.dp, Secondary, RoundedShape.medium)
    ) {
        Icon(
            painter = painter,
            contentDescription = null, tint = Black_60
        )
    }
}





