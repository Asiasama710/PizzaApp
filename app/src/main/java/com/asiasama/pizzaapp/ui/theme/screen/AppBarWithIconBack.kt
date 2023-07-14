package com.asiasama.pizzaapp.ui.theme.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asiasama.pizzaapp.R
import com.asiasama.pizzaapp.ui.theme.Black_87
import com.asiasama.pizzaapp.ui.theme.Typography

@Preview(showSystemUi = true)
@Composable
fun AppBarWithIcon( modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        ButtonIcon(onBack = {}, painter = painterResource(id = R.drawable.baseline_arrow_back_24 ))
        Text(text ="Pizza", color = Black_87, style = Typography.titleLarge)
        ButtonIcon(onBack = {}, painter = painterResource(id = R.drawable.baseline_favorite_24 ))
    }
}