package com.asiasama.pizzaapp.ui.theme.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asiasama.pizzaapp.R

@Preview(showSystemUi = true)
@Composable
fun AppBarWithIcon( modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ButtonIcon(onBack = {}, painter = painterResource(id = R.drawable.arrow_left ))
        ButtonIcon(onBack = {}, painter = painterResource(id = R.drawable.heart ))
    }
}